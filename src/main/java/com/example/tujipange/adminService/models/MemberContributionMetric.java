package com.example.tujipange.adminService.models;

import com.example.tujipange.adminService.enums.ContributionSpans;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 19/05/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contribution_metrics")
public class MemberContributionMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long metricId;

    @Column(unique = true, nullable = false)
    private String metricCode;

    @Enumerated(EnumType.STRING)
    private ContributionSpans periodEnum;

    private LocalDate dueDate;
    private BigDecimal contributionAmount;
    private float savingsPercentage;
    private float merryGoRoundPercentage;
    private float penaltyPercentage;
    private boolean status;
}

