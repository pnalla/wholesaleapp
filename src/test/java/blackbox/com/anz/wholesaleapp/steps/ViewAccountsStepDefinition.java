package blackbox.com.anz.wholesaleapp.steps;

import cucumber.api.java.en.Given;
import io.cucumber.datatable.DataTable;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

@ActiveProfiles("test")
public class ViewAccountsStepDefinition {
  private static final String VIEW_ACCOUNTS_PATH = "/v1/customer/{customerId}/account/lists";
  private String path;

  @Given("CustomerId as:$")
  public void getCustomerId(final DataTable dataTable) {
    Map<String, String> pathMap = dataTable.asMap(String.class, String.class);
    path = VIEW_ACCOUNTS_PATH.replace("{customerId", pathMap.get("customerId"));
  }

  public void viewAccounts() {
    HttpHeaders httpHeaders = new HttpHeaders();

  }

}
