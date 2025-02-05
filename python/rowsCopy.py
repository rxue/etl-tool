import argparse
import mariadb
import yaml
def readYaml(filename):
  with open(filename, 'r') as file:
    data = yaml.safe_load(file)
  return data
def _createConnection(dbConfig, name, autoCommit=True):
   conn = dbConfig[name]
   return mariadb.connect(
      user=conn["username"], 
      password=conn["password"], 
      host=conn["host"], 
      port=conn["port"],
      database=conn["schema"],
      autocommit=autoCommit,
      ssl="")
def copy(configFileName:str, sourceDatabaseAlias:str, targetDatabaseAlias:str, query:str):
  dbConfig = readYaml(configFileName)
  sourceConn = _createConnection(dbConfig, sourceDatabaseAlias)
  selectedSourceCursor = sourceConn.cursor()
  selectedSourceCursor.execute(query)
  targetConn = _createConnection(dbConfig, targetDatabaseAlias)
  insertCursor = targetConn.cursor()
  inputData = [list(r) for r in selectedSourceCursor.fetchall()]
  tableName = _getTableName(query)
  insertCursor.executemany(_formPreparedInsertStatement(tableName, len(inputData[0])), inputData)
def _getTableName(query:str):
  words = query.split()
  foundFrom = False
  for word in words:
    if word.lower() == 'from':
      foundFrom = True
      continue
    if foundFrom:
      return word

def _formPreparedInsertStatement(tableName:str, columnCount:int):
  print("column count: ", columnCount)
  questionMarks = []
  for i in range(columnCount):
    questionMarks.append('?')
  return "INSERT INTO " + tableName + " VALUES (" + ",".join(questionMarks) + ")"  


def main():
  try:
    parser = argparse.ArgumentParser(
                    prog='CopyRow',
                    description='Copy row(s) from one database to another',
                    epilog='Text at the bottom of help')
    parser.add_argument('-cf', '--configfile', help="Give configuration file name")
    parser.add_argument('-q', '--query', help="Query to retrieve rows from source database")

    args = parser.parse_args()
    configFileName = "connectionsConfig.yml"
    if args.configfile:
      configFileName = args.configfile
    copy(configFileName, 'dev','local', args.query)
  except mariadb.Error as e:
    print(f"ERROR!!!!!!!!!!: {e}")

if __name__ == "__main__":
  main()