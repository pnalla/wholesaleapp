# wholesaleapp
This microservice exposes two endpoints
  1. /v{version}/customer/{customerId}/account/lists
  2. /v{version}/account/{accountId}/transactions
  
Technologies used: Springboot, Java8, Gradle, PostgresSql, Flyway

Docker is required to run component and blackbox tests

I have used mapstructs to map the objects easily.

Implemented versioning of the api's
  
DDl Scripts:
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

I have written Unit Tests, Component Tests and blackbox test cases few of them.

To Run the app locally:
./gradlew bootRun

To run unit and component tests
./gradlew test

Before running blackbox tests you need to run ./gradlew bootRun and then run the test locally.

