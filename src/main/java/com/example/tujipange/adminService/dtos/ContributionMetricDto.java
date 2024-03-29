package com.example.tujipange.adminService.dtos;

import com.example.tujipange.userManagement.dto.EnableUserResponse;
import lombok.*;

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
@NoArgsConstructor
public class ContributionMetricDto {
    private String metricCode;
    private String periodEnum;
    private LocalDate dueDate;
    private BigDecimal ContributionAmount;
    private float savingsPercentage;
    private float merryGoRoundPercentage;
    private float penaltyPercentage;
    
    private  String errorMessage;

    public ContributionMetricDto(String noActiveMetricRecord) {
    }

    public static ContributionMetricDto failureMessage(String errorMessage) {
        return new ContributionMetricDto(errorMessage);
    }
}
