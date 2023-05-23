package com.example.tujipange.contributionsService.models;

import com.example.tujipange.user_management.models.AppUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "member_contributions",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_contributioncode",
                columnNames = "contribution_code"
        )
)
public class IndividualContributions {
    @Id
    @SequenceGenerator(
            name = "contribution_sequence",
            sequenceName = "contribution_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contribution_sequence"

    )
    private Long id;
    @Column(name = "member_number", nullable = false, unique = true)
    private String memberNumber;
    @Column(name = "contribution_code", nullable = false)
    private String contributionCode; //generated code
    @Column(name = "contributed_amount")
    private BigDecimal contributedAmount;
    @Column(name = "date_contributed")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate contributionDate;
    @Column(name = "current_balance")
    private BigDecimal pendingBalance;
    @Column(name = "expected_amount")
    private BigDecimal expectedAmount;

    @ManyToOne
    @JoinColumn(name="appuser_id")
    private AppUser appUser;

}
