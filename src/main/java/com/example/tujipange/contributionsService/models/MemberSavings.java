package com.example.tujipange.contributionsService.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/14/23
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_savings")
@Builder
public class MemberSavings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "contribution_code", unique = true)
    private String contributionCode;
    @Column(name = "savings_amount")
    private BigDecimal savingsAmount;
    @Column(name = "savings_date")
    private LocalDate savingsDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contribution_id")
    private IndividualContributions individualContributions;
}
