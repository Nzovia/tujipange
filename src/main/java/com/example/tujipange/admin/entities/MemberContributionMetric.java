package com.example.tujipange.admin.entities;

import com.example.tujipange.admin.enums.ContributionSpans;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "contribution metrics")
public class MemberContributionMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private ContributionSpans periodEnum;
    private LocalDate dueDate;
    private BigDecimal Contribution;
    private float savingsPercentage;
    private float merryGoRoundPercentage;
    private float penaltyPercentage;

}
