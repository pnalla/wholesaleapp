package com.anz.wholesaleapp.repository.account;

import com.anz.wholesaleapp.repository.account.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  List<Account> findAllByCustomerId(String customerId);

  Slice<Account>  findAllByCustomerId(String customerId, Pageable pageable);
}
