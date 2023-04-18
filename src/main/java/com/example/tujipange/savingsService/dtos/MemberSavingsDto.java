package com.example.tujipange.savingsService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberSavingsDto {
    private String memberRefNumber;
    private String contributionCode;
    private String contributionDate;
    private BigDecimal savingsAmount;
}
