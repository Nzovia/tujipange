package com.example.tujipange.savingsService.models;

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
}
