package com.example.tujipange.loanprocessing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Nicholas Nzovia
 * @On 05/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanProductDto {
    private String loanProductName;
    private Double percentage;
    private int loanPeriod;
}
