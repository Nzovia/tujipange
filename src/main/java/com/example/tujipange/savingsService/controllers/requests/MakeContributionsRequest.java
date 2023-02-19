package com.example.tujipange.savingsService.controllers.requests;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 19/02/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Data
public class MakeContributionsRequest {

    private Long userReferenceId;
    private String contributionCode;
    private BigDecimal contributedAmount;
    private LocalDateTime contributionDate;
    private LocalDateTime contributionDeadline;


}
