package com.anz.wholesaleapp.application;

import com.anz.wholesaleapp.repository.account.AccountRepository;
import com.anz.wholesaleapp.repository.account.entity.Account;
import com.anz.wholesaleapp.repository.transaction.TransactionRepository;
import com.anz.wholesaleapp.repository.transaction.entity.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
  private final AccountRepository accountRepository;
  private final TransactionRepository transactionRepository;

  @Value("${spring.accountService.pageSize:50}")
  private int pageSize;

  public List<Account> getListOfAccountsForCustomer (String customerId) {
    int pagNbr = 0;
    Slice<Account> accountSlice;
    List<Account> accountList = new ArrayList<>();
    do {
      PageRequest pageRequest = PageRequest.of(pagNbr, pageSize);
      accountSlice = accountRepository.findAllByCustomerId(customerId, pageRequest);
      pagNbr += 1;

      if (accountSlice != null) {
        accountList.addAll(accountSlice.stream().collect(Collectors.toList()));
      }
    } while (accountSlice != null && accountSlice.hasNext());
    return accountList;
  }

  public List<Transaction> getListOfTransactionForAccount (String accountNumber) {
    int pagNbr = 0;
    Slice<Transaction> transactionSlice;
    List<Transaction> transactionList = new ArrayList<>();
    do {
      PageRequest pageRequest = PageRequest.of(pagNbr, pageSize);
      transactionSlice = transactionRepository.findAllByAccountNumber(accountNumber, pageRequest);
      pagNbr += 1;

      if (transactionSlice != null) {
        transactionList.addAll(transactionSlice.stream().collect(Collectors.toList()));
      }
    } while (transactionSlice != null && transactionSlice.hasNext());
    return transactionList;
  }
}
