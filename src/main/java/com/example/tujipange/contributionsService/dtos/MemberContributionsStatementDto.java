package com.example.tujipange.contributionsService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 19/05/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
//order by Date - in Descending order with most recent date first.
public class MemberContributionsStatementDto {
    private int indexing;
    private String memberNumber;
    private String contributionCode;
    private LocalDate contributionDate;
    private BigDecimal contributionAmount;
    private BigDecimal savingsAmount;
    private BigDecimal shareAmount;
    private BigDecimal pendingBalance;

    public MemberContributionsStatementDto() {
    }

    public MemberContributionsStatementDto(String memberNumber,
                                           String contributionCode,
                                           LocalDate contributionDate,
                                           BigDecimal contributionAmount,
                                           BigDecimal savingsAmount,
                                           BigDecimal shareAmount,
                                           BigDecimal pendingBalance) {
        this.memberNumber = memberNumber;
        this.contributionCode = contributionCode;
        this.contributionDate = contributionDate;
        this.contributionAmount = contributionAmount;
        this.savingsAmount = savingsAmount;
        this.shareAmount = shareAmount;
        this.pendingBalance = pendingBalance;
    }
}
