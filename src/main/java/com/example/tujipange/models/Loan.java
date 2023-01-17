package com.example.tujipange.models;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loan_products")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String uniquecode;
    private BigDecimal amount;

    //there is one to many relationship
    //TODO. one Loan has many customers.
}
