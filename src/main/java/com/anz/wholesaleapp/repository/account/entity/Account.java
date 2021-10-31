package com.anz.wholesaleapp.repository.account.entity;

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

@Entity(name = "account")
@Table(name = "account")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "customerid", unique = true, nullable = false)
    @NotBlank
    private String customerId;

    @Column(name = "accountnumber")
    @NotBlank
    private String accountNumber;

    @Column(name = "accounttype")
    private String accountType;

    @Column(name = "accountname")
    private String accountName;

    @Column(name = "balancedate")
    private LocalDate balanceDate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "availablebalance")
    private String availableBalance;
}
