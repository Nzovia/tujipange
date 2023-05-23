package com.example.tujipange.contributionsService.repository;

import com.example.tujipange.contributionsService.models.IndividualContributions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootTest
class ContributionRepositoryTest {
    @Autowired
    private ContributionRepository contributionRepository;

    @Test
    public void TestContributionRepository(){
        var expected = 10000;
        var pendingBalance = 10000-expected;

        IndividualContributions individualContributions = IndividualContributions.builder()
                .contributedAmount(BigDecimal.valueOf(10000))
                .contributionDate(LocalDate.now())
                .contributionCode("vvzfsfag")
                .pendingBalance(BigDecimal.valueOf(pendingBalance))
                        .build();

        contributionRepository.save(individualContributions);
    }

}