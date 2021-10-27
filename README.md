# wholesaleapp
This microservice exposes two endpoints
  1. /v{version}/customer/{customerId}/account/lists
  2. /v{version}/account/{accountId}/transactions
  
Technologies used: Springboot, Java8, Gradle, H2 database, Flyway
  
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

Swagger is implemented on the api's, if we run the application locally, we can see all the documentation.
http://localhost:8090/swagger-ui.html

I have written Unit Tests, Component Tests and blackbox cucumber test cases few of them. Due to time constraint couldn't write many test cases for all the clases.
