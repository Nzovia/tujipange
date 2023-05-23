package com.example.tujipange.utils;

import com.example.tujipange.contributionsService.dtos.MemberContributionsStatementDto;
import com.example.tujipange.contributionsService.models.MemberSavings;
import com.example.tujipange.contributionsService.models.MerryGoRound;

/**
 * @author Nicholas Nzovia
 * @On 20/05/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public class ContributionMapperService {

    //converting both individualContributions and Savings + merrygoround into member contribution dto
    public static MemberContributionsStatementDto mapMemberContributionsDto(
            MemberSavings contributions, MerryGoRound merryGoRound) {
        int count = 0;
        count = count + 1;
        MemberContributionsStatementDto statementDto = new MemberContributionsStatementDto(
//                count,
                contributions.getIndividualContributions().getContributionCode(),
                contributions.getIndividualContributions().getMemberNumber(),
                contributions.getIndividualContributions().getContributionDate(),
                 contributions.getIndividualContributions().getContributedAmount(),
                contributions.getIndividualContributions().getPendingBalance(),
                contributions.getSavingsAmount(),
                merryGoRound.getShareAmount()
        );
        return statementDto;
    }
}
