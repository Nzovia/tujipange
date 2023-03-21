package com.example.tujipange.savingsService.models;

import com.example.tujipange.user_management.models.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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
public class MemberSavings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "contribution_code", unique = true)
    private String contributionCode;
    @Column(name = "phone_number")
    private String memberPhoneNumber;
    @Column(name = "amount")
    private BigDecimal savingsAmount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id") //means many savings to one user
    private AppUser appUser;
}
