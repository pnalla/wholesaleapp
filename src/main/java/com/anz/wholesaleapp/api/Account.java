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
public class Account {
  private String accountNumber;
  private String accountType;
  private String accountName;
  private LocalDate balanceDate;
  private String currency;
  private String availableBalance;
}
