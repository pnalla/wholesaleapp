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
    @Column(name = "customerId", unique = true, nullable = false)
    @NotBlank
    private String customerId;

    @Column
    @NotBlank
    private String accountNumber;

    @Column
    private String accountType;

    @Column
    private String accountName;

    @Column
    private LocalDate balanceDate;

    @Column
    private String currency;

    @Column
    private String availableBalance;
}
