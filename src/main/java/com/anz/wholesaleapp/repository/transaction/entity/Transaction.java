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
  @Column(unique = true, nullable = false)
  @NotBlank
  private String accountNumber;

  @Column
  private String accountName;

  @Column
  private LocalDate valueDate;

  @Column
  private String currency;

  @Column
  private String debitAmount;

  @Column
  private String creditAmount;

  @Column
  private String transactionType;

  @Column
  private String transactionNarrative;
}
