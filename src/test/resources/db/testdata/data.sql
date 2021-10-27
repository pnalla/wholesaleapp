
insert into account (customerId, accountNumber, accountName, accountType, balanceDate, currency, availableBalance) VALUES
    ( '12345678',  '585309209', 'SGSavings726', 'Savings', '08/11/2018', 'SGD', '84,327.51');

insert into transaction (accountNumber, accountName, valueDate, currency, debitAmount, creditAmount, transactionType, description) values
    ( '585309209',  'SGSavings726', '08/11/2018', 'SGD', '', '8,300.23', 'credit', 'international transaction');