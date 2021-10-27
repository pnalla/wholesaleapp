package unit.com.anz.wholesaleapp;

import com.anz.wholesaleapp.TestUtil;
import com.anz.wholesaleapp.application.AccountService;
import com.anz.wholesaleapp.controler.AccountController;
import com.anz.wholesaleapp.repository.account.entity.Account;
import com.anz.wholesaleapp.repository.transaction.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountControllerTest {
  @InjectMocks
  private AccountController accountController;

  @Mock
  private AccountService accountService;

  @Test
  void viewCustomerAccountLists_shouldReturnList() {
    when(accountService.getListOfAccountsForCustomer("1234567")).thenReturn(TestUtil.getAccountList());
    List<Account> accountList = (List<Account>) accountController.viewCustomerAccountLists(1, "1234567", null);
    assertAll("accountList",
            () -> assertEquals("73648595", accountList.get(0).getAccountNumber()),
            () -> assertEquals("SGDSavings", accountList.get(0).getAccountName()),
            () ->  assertEquals("Savings", accountList.get(0).getAccountType()),
            () -> assertEquals("8,8763.90", accountList.get(0).getAvailableBalance()),
            () -> assertEquals("SGD", accountList.get(0).getCurrency())
    );
  }

  @Test
  void viewAccountTransactions_shouldReturnList() {
    when(accountService.getListOfTransactionForAccount("5678253")).thenReturn(TestUtil.getTransactionList());
    List<Transaction> transactionList = (List<Transaction>) accountController.viewAccountTransactions(1, "5678253", null);
    assertAll("transactionList",
            () -> assertEquals("73648595", transactionList.get(0).getAccountNumber()),
            () -> assertEquals("SGDSavings", transactionList.get(0).getAccountName()),
            () ->  assertEquals("Savings", transactionList.get(0).getTransactionType()),
            () -> assertEquals("8,97654.09", transactionList.get(0).getDebitAmount()),
            () -> assertEquals("SGD", transactionList.get(0).getCurrency())
    );
  }


}
