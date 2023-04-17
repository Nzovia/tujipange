package com.example.tujipange.savingsService.models;

import com.example.tujipange.user_management.models.AppUser;
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
public class MonthlyShare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "contribution_code", unique = true)
    private String contributionCode;
    @Column(name = "share_amount")
    private BigDecimal savingsAmount;
    @Column(name = "share_date")
    private LocalDate contributionsDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id") //means many savings to one user
    private AppUser appUser;

}
