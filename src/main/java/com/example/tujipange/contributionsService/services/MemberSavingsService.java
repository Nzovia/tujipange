package com.example.tujipange.contributionsService.services;

import com.example.tujipange.contributionsService.dtos.MemberContributionsRequest;
import com.example.tujipange.contributionsService.models.IndividualContributions;
import com.example.tujipange.contributionsService.models.MemberSavings;
import com.example.tujipange.contributionsService.repository.ContributionRepository;
import com.example.tujipange.contributionsService.repository.MemberSavingsRepository;
import com.example.tujipange.utils.GenerateRandomNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
public class MemberSavingsService {
    private final MemberSavingsRepository memberSavingsRepository;
    private final GenerateRandomNumberService generateRandomNumberService;
    private final ContributionRepository contributionRepository;
    public MemberSavingsService(MemberSavingsRepository memberSavingsRepository,
                                GenerateRandomNumberService generateRandomNumberService,
                                ContributionRepository contributionRepository) {
        this.memberSavingsRepository = memberSavingsRepository;
        this.generateRandomNumberService = generateRandomNumberService;
        this.contributionRepository = contributionRepository;
    }

    public BigDecimal saveMoney(MemberContributionsRequest contributionsRequest, Long contributionId){
        //TODO: contributions, savings and merry-go round amount to be defined by the adminService..
        //TODO: TableName == MemberContributionsPlan -> from this table we will get necessary amounts and deadlines

        //check whether member contribution == to the expected amount -if yes call the service

        //validating that contribution exists by id
        IndividualContributions individualContributions = contributionRepository.findById(contributionId)
                .orElseThrow(() -> new EntityNotFoundException("Seems no contribution was made towards this saving"));

        var contributionAmount = contributionsRequest.getContributedAmount();
        var amountToBeSaved = BigDecimal.valueOf(250);
        var savedAmount = BigDecimal.ZERO;

        //Contributed amount less than amount to be saved
        if((contributionAmount.compareTo(amountToBeSaved) ==-1)){
            savedAmount = contributionAmount;

            //TODO. call a method that returns pending balance.

            //ContributedAmount equals to amountToBeSaved
        } else if (contributionAmount.compareTo(amountToBeSaved) == 0) {
            savedAmount = contributionAmount;
        }else{
            //check whether expected amount is equal to contributed amount.

        }

        var savingsCode = "Sa"+ generateRandomNumberService.generateRandomNumber();

        MemberSavings memberSavings = MemberSavings.builder()
                .contributionCode(savingsCode)
                .savingsAmount(contributionsRequest.getContributedAmount())
                .savingsDate(LocalDate.now())
                .individualContributions(individualContributions)
                .build();

        memberSavingsRepository.save(memberSavings);
        //Return balance
        return BigDecimal.ZERO;
    }
}
