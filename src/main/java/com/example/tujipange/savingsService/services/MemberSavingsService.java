package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.dtos.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.MemberSavings;
import com.example.tujipange.savingsService.repository.MemberSavingsRepository;
import com.example.tujipange.utils.GenerateRandomNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Nicholas Nzovia
 * @On 12/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@RequiredArgsConstructor
public class MemberSavingsService {
    private final MemberSavingsRepository memberSavingsRepository;
    private final GenerateRandomNumberService generateRandomNumberService;

    public void saveMoney(MemberContributionsRequest contributionsRequest){
        //check whether member contribution == to the expected amount -if yes call the service
        var amountToBesaved = BigDecimal.ZERO;
        if((contributionsRequest.getContributedAmount()).compareTo(amountToBesaved)<-1){

            //

        }
        var savingsCode = "Sa"+ generateRandomNumberService.generateRandomNumber();

        MemberSavings memberSavings = MemberSavings.builder()
                .contributionCode(savingsCode)
                .savingsAmount(contributionsRequest.getContributedAmount())
                .savingsDate(LocalDate.now())
                .build();

    }
}
