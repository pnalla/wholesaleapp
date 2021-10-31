package com.anz.wholesaleapp.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
  private String accountNumber;
  private String accountName;
  private LocalDate valueDate;
  private String currency;
  private String debitAmount;
  private String creditAmount;
  private String transactionType;
  private String transactionNarrative;
}
