package com.example.tujipange.savingsService.services;

import com.example.tujipange.savingsService.dtos.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.IndividualContributions;
import com.example.tujipange.savingsService.repository.ContributionRepository;
import com.example.tujipange.user_management.models.AppUser;
import com.example.tujipange.user_management.repository.AppuserRepository;
import com.example.tujipange.utils.GenerateRandomNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    private final ContributionRepository contributionRepository;
    private AppuserRepository appuserRepository;
    private final GenerateRandomNumberService generateRandomNumberService;

    //members making their contributions
    public ContributionsService(ContributionRepository contributionRepository,
                                AppuserRepository appuserRepository,
                                GenerateRandomNumberService generateRandomNumberService) {
        this.contributionRepository = contributionRepository;
        this.appuserRepository = appuserRepository;
        this.generateRandomNumberService = generateRandomNumberService;
    }

    public void makeContributions(MemberContributionsRequest request, Long userId) {
        var contributedAmount = request.getContributedAmount();

        if(Objects.equals(contributedAmount, new BigDecimal(0))){
            log.error("the contributed amount is null {}", contributedAmount);
        }

        //The value will be gotten from admin table
        var expectedAmount = 500;
        var contributionCode = "Cn"+ generateRandomNumberService.generateRandomNumber();

        IndividualContributions individualContributions = new IndividualContributions();
        AppUser appUser = appuserRepository.findById(userId)
                        .orElseThrow(() -> new EntityNotFoundException("Sorry User with ID not found"));
                individualContributions.setAppUser(appUser);

                //call a method to check if memberNumber exists
                checkIfMemberNumberExists(request);
                individualContributions.setMemberNumber(request.getMemberNumber());
                individualContributions.setContributionCode(contributionCode);
                individualContributions.setExpectedAmount(BigDecimal.valueOf(expectedAmount));
                individualContributions.setContributedAmount(contributedAmount);
                individualContributions.setContributionDate(LocalDate.now());
                individualContributions.setPendingBalance(
                        BigDecimal.valueOf(expectedAmount).subtract(contributedAmount));

        log.info("can't get the value {}",String.valueOf(individualContributions));

        contributionRepository.saveAndFlush(individualContributions);

        log.info("savings with code {} added successfully ", individualContributions.getContributedAmount());

        //TODO: here call the savings method and the merry-go round...
        // savings account goes to the savings till while
        // merrygo the contributions goes to savings tillnumber(PayBill)


        //after contributions call savings service...


    }
    private void checkIfMemberNumberExists(MemberContributionsRequest request) {
        if(contributionRepository.existsByMemberNumber(request.getMemberNumber())){
            //handle the case when email and phoneNumber already exists
            throw new IllegalArgumentException("MemberNumber already exists");
        }
    }

    public List<IndividualContributions> getAllMemberContributions() {
        var contributions = contributionRepository.findAll();
        return contributions;
    }
}
