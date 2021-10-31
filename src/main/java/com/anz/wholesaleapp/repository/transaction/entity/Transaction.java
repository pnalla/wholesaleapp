package com.anz.wholesaleapp.repository.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity(name = "transaction")
@Table(name = "transaction")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  @Id
  @Column(unique = true, name = "accountnumber", nullable = false)
  @NotBlank
  private String accountNumber;

  @Column(name = "accountname")
  private String accountName;

  @Column(name = "valuedate")
  private LocalDate valueDate;

  @Column(name = "currency")
  private String currency;

  @Column(name = "debitamount")
  private String debitAmount;

  @Column(name = "creditamount")
  private String creditAmount;

  @Column(name = "transactiontype")
  private String transactionType;

  @Column(name = "transactionnarrative")
  private String transactionNarrative;
}
