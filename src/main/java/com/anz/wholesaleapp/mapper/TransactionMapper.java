package com.anz.wholesaleapp.mapper;

import com.anz.wholesaleapp.api.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper {
  public abstract List<Transaction> mapAccounts(List<com.anz.wholesaleapp.repository.transaction.entity.Transaction> transactionList);
}
