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
     description varchar(200)
);


insert into account (customerId, accountNumber, accountName, accountType, balanceDate, currency, availableBalance) VALUES
    ( '12345678',  '585309209', 'SGSavings726', 'Savings', '08/11/2018', 'SGD', '84,327.51');

insert into transaction (accountNumber, accountName, valueDate, currency, debitAmount, creditAmount, transactionType, description) values
    ( '585309209',  'SGSavings726', '08/11/2018', 'SGD', '', '8,300.23', 'credit', 'international transaction');