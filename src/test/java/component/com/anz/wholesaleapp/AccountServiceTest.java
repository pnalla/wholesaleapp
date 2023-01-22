package component.com.anz.wholesaleapp;


import com.anz.wholesaleapp.api.Account;
import com.anz.wholesaleapp.api.Transaction;
import com.anz.wholesaleapp.application.AccountService;
import com.anz.wholesaleapp.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ComponentTest
@Sql(scripts = {"/db/testdata/data_cleanup.sql", "/db/testdata/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
@Sql(scripts = {"/db/testdata/data_cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class AccountServiceTest {
  @Autowired
  private AccountService accountService;

  @Test
  void getListOfAccountsForCustomer_shouldReturnList() {
    List<Account> accountList = accountService.retrieveCustomerAccounts("12345678");
    assertAll("accountList",
        () -> assertEquals("585309209", accountList.get(0).getAccountNumber()),
        () -> assertEquals("SGSavings726", accountList.get(0).getAccountName()),
        () ->  assertEquals("Savings", accountList.get(0).getAccountType()),
        () -> assertEquals("84,327.51", accountList.get(0).getAvailableBalance()),
        () -> assertEquals("SGD", accountList.get(0).getCurrency())
    );
  }

  @Test
  void getListOfAccountsForCustomer_invalidCustomerId_shouldThrowException() {
    DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class, () -> accountService.retrieveCustomerAccounts("customerid"));
    assertAll("dataNotFoundException",
            () -> assertNotNull(dataNotFoundException),
            () -> assertEquals("API-400", dataNotFoundException.getApiError().getErrorId()),
            () ->  assertEquals("No data found for this customer", dataNotFoundException.getApiError().getMessage())
    );
  }

  @Test
  void getListOfTransactionForAccount_shouldReturnList() {
    List<Transaction> transactionList = accountService.retrieveAccountTransactions("585309209");
    assertAll("transactionList",
        () -> assertEquals("585309209", transactionList.get(0).getAccountNumber()),
        () -> assertEquals("SGSavings726", transactionList.get(0).getAccountName()),
        () -> assertEquals("credit", transactionList.get(0).getTransactionType()),
        () -> assertEquals("8,300.23", transactionList.get(0).getCreditAmount()),
        () -> assertEquals("SGD", transactionList.get(0).getCurrency())
    );
  }

  @Test
  void getListOfTransactionForAccount_invalidAccountNumber_shouldThrowException() {
    DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class, () -> accountService.retrieveAccountTransactions("73643428595"));
    assertAll("dataNotFoundException",
            () -> assertNotNull(dataNotFoundException),
            () -> assertEquals("API-400", dataNotFoundException.getApiError().getErrorId()),
            () ->  assertEquals("No data found for this account", dataNotFoundException.getApiError().getMessage())
    );
  }
}