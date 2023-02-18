package com.example.tujipange.savingsService.models;

import com.example.tujipange.user_management.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_contributions")
public class Contributions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "f_name", nullable = false)
    private String transactionCode; //generated code
    private BigDecimal contributedAmount;
    private BigDecimal pendingBalance;

    //many contributions are made by a single app user
    @ManyToOne
    @JoinColumn(name="appuser_id")
    private AppUser appUser;
}
