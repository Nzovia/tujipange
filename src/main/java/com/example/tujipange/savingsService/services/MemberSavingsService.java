package com.example.tujipange.savingsService.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "member_savings")
public class MemberSavingsService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String memberName;
    @Column(name = "contribution_code", unique = true)
    private String contributionCode;
    @Column(name = "phone_number")
    private String memberPhoneNumber;
    @Column(name = "amount")
    private BigDecimal savingsAmount;
}
