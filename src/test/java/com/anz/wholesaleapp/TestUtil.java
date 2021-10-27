package com.anz.wholesaleapp;

import com.anz.wholesaleapp.repository.account.entity.Account;
import com.anz.wholesaleapp.repository.transaction.entity.Transaction;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class TestUtil {
  public static List<Transaction> getTransactionList() {
    return Collections.singletonList(Transaction.builder()
            .accountNumber("73648595")
            .accountName("SGDSavings")
            .creditAmount("")
            .transactionType("Savings")
            .currency("SGD")
            .debitAmount("8,97654.09")
            .valueDate(LocalDate.of(2018, 10, 8)).build());
  }

  public static List<Account> getAccountList() {
    return Collections.singletonList(Account.builder()
            .customerId("1234567")
            .accountNumber("73648595")
            .accountName("SGDSavings")
            .accountType("Savings")
            .availableBalance("8,8763.90")
            .currency("SGD")
            .build());
  }
}
