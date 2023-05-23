package com.example.tujipange.contributionsService.repository;

import com.example.tujipange.contributionsService.dtos.MemberContributionsStatementDto;
import com.example.tujipange.contributionsService.models.IndividualContributions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionRepository extends JpaRepository<IndividualContributions, Long> {
    boolean existsByMemberNumber(String memberNumber);
    @Query(
            "SELECT new com.example.tujipange.contributionsService.dtos.MemberContributionsStatementDto" +
                    "(co.memberNumber, co.contributionCode, co.contributionDate,co.contributedAmount, " +
                    " sa.savingsAmount, me.shareAmount, co.pendingBalance) " +
                    "FROM IndividualContributions AS co " +
                    "INNER JOIN MemberSavings AS sa ON co.id = sa.individualContributions.id " +
                    "INNER JOIN MerryGoRound AS me ON co.id = me.individualContributions.id"
    )
    List<MemberContributionsStatementDto> findIndividualMemberContributions();
}
