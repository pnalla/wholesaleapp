package component.com.anz.wholesaleapp;

import com.anz.wholesaleapp.TestUtil;
import com.anz.wholesaleapp.api.Account;
import com.anz.wholesaleapp.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentTest
public class AccountMapperTest {

  @Autowired
  private AccountMapper accountMapper;

  @Test
  void map_whenMapAccounts() {
    List<Account> accountList = accountMapper.mapAccounts(TestUtil.getAccountList());
    assertAll("accountList",
            () -> assertEquals("73648595", accountList.get(0).getAccountNumber()),
            () -> assertEquals("SGDSavings", accountList.get(0).getAccountName()),
            () ->  assertEquals("Savings", accountList.get(0).getAccountType()),
            () -> assertEquals("8,8763.90", accountList.get(0).getAvailableBalance()),
            () -> assertEquals("SGD", accountList.get(0).getCurrency())
    );
  }
}
