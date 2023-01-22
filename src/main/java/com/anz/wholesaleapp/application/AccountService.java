package com.anz.wholesaleapp.application;

import com.anz.wholesaleapp.exception.DataNotFoundException;
import com.anz.wholesaleapp.mapper.AccountMapper;
import com.anz.wholesaleapp.mapper.TransactionMapper;
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
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
  private final AccountRepository accountRepository;
  private final TransactionRepository transactionRepository;
  private final AccountMapper accountMapper;
  private final TransactionMapper transactionMapper;

  @Value("${spring.accountService.pageSize:50}")
  private int pageSize;

  /**
   * This method gets all the customer accounts from postgres database.
   * @param customerId String.
   * @return accountList.
   */
  public List<com.anz.wholesaleapp.api.Account> retrieveCustomerAccounts(String customerId) {
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

    if (CollectionUtils.isEmpty(accountList)) {
      throw new DataNotFoundException("No data found for this customer");
    }
    return accountMapper.mapAccounts(accountList);
  }

  /**
   * This method gets all account transactions.
   * @param accountNumber String.
   * @return transactionList.
   */
  public List<com.anz.wholesaleapp.api.Transaction> retrieveAccountTransactions(String accountNumber) {
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

    if (CollectionUtils.isEmpty(transactionList)) {
      throw new DataNotFoundException("No data found for this account");
    }
    return transactionMapper.mapAccounts(transactionList);
  }
}
