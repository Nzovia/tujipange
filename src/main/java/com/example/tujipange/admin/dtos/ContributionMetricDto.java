package com.example.tujipange.admin.dtos;

import com.example.tujipange.admin.enums.ContributionSpans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 28/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContributionMetricDto {
    private String periodEnum;
    private LocalDate dueDate;
    private BigDecimal ContributionAmount;
    private float savingsPercentage;
    private float merryGoRoundPercentage;
    private float penaltyPercentage;
}
