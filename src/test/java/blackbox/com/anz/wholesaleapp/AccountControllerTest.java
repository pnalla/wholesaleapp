package blackbox.com.anz.wholesaleapp;

import component.com.anz.wholesaleapp.ComponentTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

@ComponentTest
public class AccountControllerTest {
  private static final String BASE_URI = "http:localhost";
  private static final String BASE_PATH = "/wholesale-app";
  private static final Integer PORT = 8090;
  private static final String VIEW_ACCOUNTS = "/v1/customer/12345678/account/lists";

  @BeforeAll
  static void setUp() {
    RestAssured.baseURI = BASE_URI;
    RestAssured.basePath = BASE_PATH;
    RestAssured.port = PORT;
  }

  @Test
  @Sql(scripts = {"/db/testdata/data_cleanup.sql", "/db/testdata/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
  @Sql(scripts = {"/db/testdata/data_cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config= @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED))
  void givenValidRequest_getAllTheAccountForTheCustomer() {
    Map<String, String> headers = new HashMap<>();
    headers.put("X_CORRELATION_ID","12345678");

    given()
            .log().all()
            .headers(headers)
            .accept("application/json")
            .when()
            .get(VIEW_ACCOUNTS)
            .then()
            .log().all()
            .statusCode(SC_OK)
            .contentType(ContentType.JSON)
            .body(not(empty()));
  }
}
