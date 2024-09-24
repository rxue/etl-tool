import mariadb
import yaml
def readYaml(filename):
  with open(filename, 'r') as file:
    data = yaml.safe_load(file)
  return data
def createConnection(dbConfig, name, autoCommit=True):
   conn = dbConfig[name]
   return mariadb.connect(
        user=conn["username"], 
        password=conn["password"], 
        host=conn["host"], 
        port=conn["port"],
        database=conn["schema"],
        autocommit=autoCommit,
        ssl="")

try:
    dbConfig = readYaml("connectionsConfig.yml")
    sourceConn = createConnection(dbConfig, "dev")
    selectedSourceCursor = sourceConn.cursor()
    selectedSourceCursor.execute("select * from qrtz_cron_triggers where trigger_name = 'SCHEDULED_PROCESS-processLauncher-91623755459453'")
    targetConn = createConnection(dbConfig, "local")
    insertCursor = targetConn.cursor()
    inputData = [list(r) for r in selectedSourceCursor.fetchall()]
    insertCursor.executemany("INSERT INTO qrtz_cron_triggers VALUES (?,?,?,?,?)", inputData)
except mariadb.Error as e:
    print(f"ERROR!!!!!!!!!!: {e}")