package component.com.anz.wholesaleapp;


import com.anz.wholesaleapp.application.AccountService;
import com.anz.wholesaleapp.repository.account.AccountRepository;
import com.anz.wholesaleapp.repository.account.entity.Account;
import com.anz.wholesaleapp.repository.transaction.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentTest
@Sql(scripts = {"/db/testdata/data_cleanup.sql", "/db/testdata/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
@Sql(scripts = {"/db/testdata/data_cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class AccountServiceTest {
  @Autowired
  private AccountService accountService;

  @MockBean
  private AccountRepository accountRepository;

  @Test
  void getListOfAccountsForCustomer_shouldReturnList() {
    List<Account> accountList = accountService.getListOfAccountsForCustomer("12345678");
    assertAll("accountList",
        () -> assertEquals("73648595", accountList.get(0).getAccountNumber()),
        () -> assertEquals("SGDSavings", accountList.get(0).getAccountName()),
        () ->  assertEquals("Savings", accountList.get(0).getAccountType()),
        () -> assertEquals("8,8763.90", accountList.get(0).getAvailableBalance()),
        () -> assertEquals("SGD", accountList.get(0).getCurrency())
    );
  }

  @Test
  void getListOfTransactionForAccount_shouldReturnList() {
    List<Transaction> transactionList = accountService.getListOfTransactionForAccount("585309209");
    assertAll("transactionList",
        () -> assertEquals("585309209", transactionList.get(0).getAccountNumber()),
        () -> assertEquals("'SGSavings726'", transactionList.get(0).getAccountName()),
        () -> assertEquals("'credit'", transactionList.get(0).getTransactionType()),
        () -> assertEquals("8,300.23", transactionList.get(0).getDebitAmount()),
        () -> assertEquals("SGD", transactionList.get(0).getCurrency())
    );
  }
}