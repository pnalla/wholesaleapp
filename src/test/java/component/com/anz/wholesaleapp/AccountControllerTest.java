package component.com.anz.wholesaleapp;

import com.anz.wholesaleapp.TestUtil;
import com.anz.wholesaleapp.mapper.AccountMapper;
import com.anz.wholesaleapp.repository.account.AccountRepository;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.SliceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static unit.com.anz.wholesaleapp.AccountServiceTest.CUSTOMER_ID;

@ComponentTest
@AutoConfigureMockMvc
@Sql(scripts = {"/db/testdata/data_cleanup.sql", "/db/testdata/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
@Sql(scripts = {"/db/testdata/data_cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class AccountControllerTest {

  public static final String ACCOUNT_LISTS = "/v1/customer/12345678/account/lists";
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private AccountMapper accountMapper;

  @Test
  void getListOfAccount_noData_shouldThrowException() throws Exception {
    PageRequest pageRequest = PageRequest.of(0, 5);
    Mockito.when(accountRepository.findAllByCustomerId(CUSTOMER_ID, pageRequest)).thenReturn(new SliceImpl<>(TestUtil.getAccountList(), pageRequest, false));
    Mockito.when(accountMapper.mapAccounts(any())).thenReturn(TestUtil.getAccountApiList());
    mockMvc.perform(get(ACCOUNT_LISTS)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .headers(new HttpHeaders()))
            .andExpect(status().is4xxClientError());
  }
}
