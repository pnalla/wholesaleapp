package com.anz.wholesaleapp.repository.transaction;

import com.anz.wholesaleapp.repository.transaction.entity.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
  List<Transaction> findAllByAccountNumber(String accountNumber);

  Slice<Transaction> findAllByAccountNumber(String accountNumber, Pageable pageable);
}
