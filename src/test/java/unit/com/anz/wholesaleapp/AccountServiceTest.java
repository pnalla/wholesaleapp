package unit.com.anz.wholesaleapp;

import com.anz.wholesaleapp.TestUtil;
import com.anz.wholesaleapp.application.AccountService;
import com.anz.wholesaleapp.repository.account.AccountRepository;
import com.anz.wholesaleapp.repository.account.entity.Account;
import com.anz.wholesaleapp.repository.transaction.TransactionRepository;
import com.anz.wholesaleapp.repository.transaction.entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.SliceImpl;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountServiceTest {

  public static final String CUSTOMER_ID = "1234567";
  @InjectMocks
  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  @Mock
  private TransactionRepository transactionRepository;

  @BeforeEach
  void initialize() {
    ReflectionTestUtils.setField(accountService, "pageSize", 5);
  }

  @Test
  void getListOfAccountsForCustomers_shouldReturnList() {
    PageRequest pageRequest = PageRequest.of(0, 5);
    when(accountRepository.findAllByCustomerId(CUSTOMER_ID, pageRequest)).thenReturn(new SliceImpl<>(TestUtil.getAccountList(), pageRequest, false));

    List<Account> accountList = accountService.getListOfAccountsForCustomer(CUSTOMER_ID);
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
    PageRequest pageRequest = PageRequest.of(0, 5);
    when(transactionRepository.findAllByAccountNumber("73648595", pageRequest)).thenReturn(new SliceImpl<>(TestUtil.getTransactionList(), pageRequest, false));

    List<Transaction> transactionList = accountService.getListOfTransactionForAccount("73648595");
    assertAll("transactionList",
        () -> assertEquals("73648595", transactionList.get(0).getAccountNumber()),
        () -> assertEquals("SGDSavings", transactionList.get(0).getAccountName()),
        () ->  assertEquals("Savings", transactionList.get(0).getTransactionType()),
        () -> assertEquals("8,97654.09", transactionList.get(0).getDebitAmount()),
        () -> assertEquals("SGD", transactionList.get(0).getCurrency())
    );

  }


}
