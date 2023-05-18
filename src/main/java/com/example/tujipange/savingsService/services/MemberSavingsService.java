package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.dtos.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.MemberSavings;
import com.example.tujipange.savingsService.repository.MemberSavingsRepository;
import com.example.tujipange.utils.GenerateRandomNumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private  MemberSavingsRepository memberSavingsRepository;
    @Autowired
    private  GenerateRandomNumberService generateRandomNumberService;

    public BigDecimal saveMoney(MemberContributionsRequest contributionsRequest){
        //TODO: contributions, savings and merry-go round amount to be defined by the admin..
        //TODO: TableName == MemberContributionsPlan -> from this table we will get necessary amounts and deadlines

        //check whether member contribution == to the expected amount -if yes call the service
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
                .build();

        memberSavingsRepository.save(memberSavings);
        //Return balance
        return BigDecimal.ZERO;
    }
}
