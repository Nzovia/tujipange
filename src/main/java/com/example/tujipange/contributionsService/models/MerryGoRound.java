package com.example.tujipange.contributionsService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "merry_go_round")
public class MerryGoRound {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "contribution_code", unique = true)
    private String contributionCode;
    @Column(name = "share_amount")
    private BigDecimal shareAmount;
    @Column(name = "share_date")
    private LocalDate contributionsDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "individual_contributions_id")
    private IndividualContributions individualContributions;

}
