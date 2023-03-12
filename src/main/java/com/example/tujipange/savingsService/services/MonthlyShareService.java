package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.models.Contributions;
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
@Table(name = "merry_go_round")
public class MonthlyShareService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "contributions_id", referencedColumnName = "id")
    private Contributions contributions; //here get MemberName, memberPhone, and contributionCode

    //50 percent of the total monthly contributions
    @Column(name = "merry_go_amount")
    private BigDecimal merryGoAmount;
}
