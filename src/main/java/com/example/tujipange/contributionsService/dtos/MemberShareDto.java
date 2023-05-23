package com.example.tujipange.contributionsService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberShareDto {

    //conca fname and lname
    private String memberName;
    private String contributionCode;
    private String contributionDate;
    private String memberPhoneNumber;
    private BigDecimal savingsAmount;
}
