package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.dtos.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.Contributions;
import com.example.tujipange.savingsService.repository.ContributionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author Nicholas Nzovia
 * @On 19/02/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
public class ContributionsService {
    private final ContributionRepository repository;

    //members making their contributions
    public ContributionsService(ContributionRepository repository) {
        this.repository = repository;
    }

    public String makeContributions(MemberContributionsRequest request) {
        var contributedAmount = request.getContributedAmount();

        if(Objects.equals(contributedAmount, new BigDecimal(0))){
            log.error("the contributed amount is null {}", contributedAmount);
        }

        var expectedAmount = 100;
        Contributions contributed = Contributions.builder()

                .contributionCode(request.getContributionCode())
                .expectedAmount(BigDecimal.valueOf(expectedAmount))
                .contributedAmount(contributedAmount)
                .contributionDate(LocalDate.now())
                .pendingBalance(contributedAmount.subtract(BigDecimal.valueOf(expectedAmount)))
                        .build();
        log.info("can't get the value {}",String.valueOf(contributed));


        repository.save(contributed);

        return "records added successfully";
    }

    public List<Contributions> getAllMemberContributions() {
        var contributions = repository.findAll();
        return contributions;
    }
}
