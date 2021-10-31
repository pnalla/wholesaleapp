
insert into account (customerId, accountNumber, accountName, accountType, balanceDate, currency, availableBalance) VALUES
    ( '12345678',  '585309209', 'SGSavings726', 'Savings', '2018-02-03', 'SGD', '84,327.51');

insert into transaction (accountNumber, accountName, valueDate, currency, debitAmount, creditAmount, transactionType, transactionNarrative) values
    ( '585309209',  'SGSavings726', '2018-02-03', 'SGD', '', '8,300.23', 'credit', 'international transaction');