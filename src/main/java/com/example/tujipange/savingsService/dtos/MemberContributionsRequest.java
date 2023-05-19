package com.example.tujipange.savingsService.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 19/02/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberContributionsRequest {
    private Long userId;
    private String memberNumber;
    private BigDecimal contributedAmount;
    private LocalDateTime contributionDate;
    //private LocalDateTime contributionDeadline;
}
