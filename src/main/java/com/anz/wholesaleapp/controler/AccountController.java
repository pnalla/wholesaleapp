package com.anz.wholesaleapp.controler;

import com.anz.wholesaleapp.repository.account.entity.Account;
import com.anz.wholesaleapp.repository.transaction.entity.Transaction;
import com.anz.wholesaleapp.application.AccountService;
import com.anz.wholesaleapp.versioning.RequestVersions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class AccountController {
  private final AccountService accountService;

  @GetMapping("/v{version}/customer/{customerId}/account/lists")
  @RequestVersions(supportedVersions = { 1 }, togglePropertyPrefix = "toggle.accountLists")
  public ResponseEntity<List<Account>> viewCustomerAccountLists(
          @PathVariable final int version,
          @PathVariable("customerId") @NotBlank final String customerId,
          @RequestHeader final HttpHeaders requestHeaders) {
    return new ResponseEntity<>(accountService.getListOfAccountsForCustomer(customerId), HttpStatus.OK);
  }

  @GetMapping("/v{version}/account/{accountId}/transactions")
  @RequestVersions(supportedVersions = { 1 }, togglePropertyPrefix = "toggle.transactionLists")
  public ResponseEntity<List<Transaction>> viewAccountTransactions(
          @PathVariable final int version,
          @PathVariable("accountId") @NotBlank final String accountId,
          @RequestHeader final HttpHeaders requestHeaders) {
    return new ResponseEntity<>(accountService.getListOfTransactionForAccount(accountId), HttpStatus.OK);
  }
}

