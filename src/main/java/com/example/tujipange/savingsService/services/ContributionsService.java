package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.controllers.requests.MakeContributionsRequest;
import com.example.tujipange.savingsService.models.Contributions;
import com.example.tujipange.savingsService.repository.ContributionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 19/02/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
public class ContributionsService {
    private final ContributionRepository repository;
    public ContributionsService(ContributionRepository repository) {
        this.repository = repository;
    }

    public String makeContributions(MakeContributionsRequest request) {
        Contributions contributed = new Contributions();
        var contributedAmount = request.getContributedAmount();
        var expectedAmount = 100;

        contributed.setContributionCode("MakeRandomUniqueString");
        contributed.setContributedAmount(contributedAmount);
        contributed.setContributionDate(LocalDate.now());
        contributed.setPendingBalance(contributedAmount.subtract(BigDecimal.valueOf(expectedAmount)));

        repository.save(contributed);

        return "records added successfully" ;
    }
}
