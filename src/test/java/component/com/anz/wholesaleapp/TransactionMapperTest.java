package component.com.anz.wholesaleapp;

import com.anz.wholesaleapp.TestUtil;
import com.anz.wholesaleapp.api.Transaction;
import com.anz.wholesaleapp.mapper.TransactionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentTest
public class TransactionMapperTest {
  @Autowired
  private TransactionMapper transactionMapper;

  @Test
  void map_whenTransactionForAccount() {
    List<Transaction> transactionList = transactionMapper.mapAccounts(TestUtil.getTransactionList());
    assertAll("transactionList",
            () -> assertEquals("73648595", transactionList.get(0).getAccountNumber()),
            () -> assertEquals("SGDSavings", transactionList.get(0).getAccountName()),
            () ->  assertEquals("Savings", transactionList.get(0).getTransactionType()),
            () -> assertEquals("8,97654.09", transactionList.get(0).getDebitAmount()),
            () -> assertEquals("SGD", transactionList.get(0).getCurrency())
    );

  }
}
