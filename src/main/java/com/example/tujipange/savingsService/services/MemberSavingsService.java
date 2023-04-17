package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.dtos.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.MemberSavings;
import com.example.tujipange.savingsService.repository.MemberSavingsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
public class MemberSavingsService {
    private final MemberSavingsRepository memberSavingsRepository;
    public MemberSavingsService(MemberSavingsRepository memberSavingsRepository) {
        this.memberSavingsRepository = memberSavingsRepository;
    }

    public void saveMoney(MemberContributionsRequest contributionsRequest){
        //check whether member contribution == to the expected amount -if yes call the service
        var amountToBesaved = BigDecimal.ZERO;
        if((contributionsRequest.getContributedAmount()).compareTo(amountToBesaved)<-1){

            //

        }

        MemberSavings memberSavings = MemberSavings.builder()
                .contributionCode(contributionsRequest.getContributionCode())
                .savingsAmount(contributionsRequest.getContributedAmount())
                .savingsDate(LocalDate.now())
                .build();

    }
}
