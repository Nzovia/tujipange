package com.example.tujipange.savingsService.models;

import com.example.tujipange.user_management.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_contributions")
public class Contributions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contribution_code", nullable = false)
    private String contributionCode; //generated code
    @Column(name = "contributed_amount")
    private BigDecimal contributedAmount;
    @Column(name = "contribution_deadline")
    private  LocalDateTime contributionDeadline;
    @Column(name = "date_contributed")
    private LocalDateTime contributionDate;
    @Column(name = "current_balance")
    private BigDecimal pendingBalance;

    //many contributions are made by a single app user
    @ManyToOne
    @JoinColumn(name="appuser_id")
    private AppUser appUser;
}
