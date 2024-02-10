package com.example.tujipange.loanProcessing.models;

import com.example.tujipange.loanProcessing.enums.LoanProductName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name =" Loan_Products")

public class LoanProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 10)
    private String productCode;
    @Column(nullable = false, name = "loan_product")
    private LoanProductName loanProductName; //there are four names of the products(Bronze, Silver, Gold and platuinum)
    @Column(nullable = false, name = "loan_percentage")
    private Double percentage; //computes percentage by which your loan will be from the saving
    private int loanPeriod; //number of days from loan request to payment day
    @Column(name = "product_status") //Active/INACTIVE
    private Boolean status;


}
