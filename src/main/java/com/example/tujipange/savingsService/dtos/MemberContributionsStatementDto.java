package com.example.tujipange.savingsService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    private String indexing;
    private String memberNumber;
    private String contributionCode;
    private String  contributionDate;
    private String contributionAmount;
    private String savingsAmount;
    private String merryGoroundAmount;
    private String pendingBalance;

}
