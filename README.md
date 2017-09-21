# ETL Solution in Java 
## Assumption:
* any WAGER row and its corresponding RESULT row are always adjacent
* no repeating RESULT rows for each BETID

## Algorithm
Combine the WAGER row and the corresponding RESULT row into one and then persist it into the relational database

## Frameworks Used
* Spring Core
* Spring Data JPA
* Hibernate
   
