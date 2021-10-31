package com.anz.wholesaleapp.mapper;

import com.anz.wholesaleapp.repository.account.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

  public abstract List<com.anz.wholesaleapp.api.Account> mapAccounts(List<Account> accountList);

}
