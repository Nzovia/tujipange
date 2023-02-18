package com.example.tujipange.savingsService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/14/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String loanCode;
    private BigDecimal amount;

    //Todo: add a relation between the Payments and Loans
    //Todo: add a relationship between users and payments
}
