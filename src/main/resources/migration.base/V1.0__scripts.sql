DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS transaction;

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
     transactionNarrative varchar(200)
);