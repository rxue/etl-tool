import mariadb
try:
    conn = mariadb.connect(
        user="user", 
        password="xxx", 
        host="host", 
        port=3306,
        database="schemaname",
        ssl="")
    cur = conn.cursor()
    cur.execute("select * from contact where name = 'Customer'")
    for c in cur:
        print(c)
except mariadb.Error as e:
    print(f"ERROR!!!!!!!!!!: {e}")