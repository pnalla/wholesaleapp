# wholesaleapp

```
The application allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.

- View account list
- View account transactions
```

### This microservice exposes two endpoints
1. /v{version}/customer/{customerId}/account/lists
2. /v{version}/account/{accountId}/transactions

### Technologies and libraries used:
Springboot
Java8
Gradle
PostgresSql
Flyway
docker
mapstructs
openswagger

```
1.Docker is required to run blackbox tests
2.I have used mapstructs to map the objects easily.
3.Implemented versioning of the api's 
4. Custom exception "DataNotFound" is thrown if the data doesn't exists
5. Added mapstruct implementaion to show extra skills
```

### DDl Scripts:

```
CREATE TABLE account (
customerId varchar(50) not null primary key ,
accountNumber varchar(50),
accountName varchar(50),
accountType varchar(10),
balanceDate date,
currency varchar(3),
availableBalance varchar(50)
);

CREATE TABLE transaction (
accountNumber varchar(50) not null primary key ,
accountName varchar(50),
valueDate date,
currency varchar(3),
debitAmount varchar(50),
creditAmount varchar(50),
transactionType varchar(10),
description varchar(200)
);

First one will get all the accounts for a particular customer
Second one will get all the transaction for a particular account. pagination is implemented in service class for better performance in sql query (just added as an extra feature)

```


### To Run the app locally:
```
./gradlew bootRun
```

### Running the tests
```
./gradlew test
```

### Running blackbox tests
```
Before running blackbox tests you need to run 
./gradlew bootRun 
and then run 
./gradlew test
```
