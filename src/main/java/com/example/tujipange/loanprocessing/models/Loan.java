package com.example.tujipange.loanprocessing.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private Long id;
    private String loanCode;
    private BigDecimal amount;
    private String loanStatus; //enum -> Paid, Unpaid, Partially paid
    private  BigDecimal loanPenalty; //computed from percentage of the loan and due dates.
    private LocalDateTime dateBorrowed;
    private LocalDateTime dueDate;



    //there is one to many relationship
    //TODO. one Loan has many customers.
}
