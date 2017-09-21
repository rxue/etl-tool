# ETL Solution in SQL
## `sql/mysql/import_factBetTransaction.sql` 
This script `LOAD`/import raw transaction data from CSV into a "temporary" table at first. After several steps of processing, the ready data, say each row contains both turnover and winning amount with a unique *surrogage key*, are inserted into the fact table eventually.

NOTE! In the `LOAD DATE` line, the csv `FactGameTransaction.csv` has be replaced with an existing (daily) transaction csv dump if one wants to run it for testing

## SUMMARY
The previous solution is done in Java in the branch https://github.com/rxue/etl-practice/tree/old_java_solution/ 

Thanks to a datawarehouse professional, after his enlightenment, this solution came out with pure SQL, which is much more maintainable than Java.
