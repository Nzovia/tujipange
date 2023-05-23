package com.example.tujipange.contributionsService.services;

import com.example.tujipange.contributionsService.dtos.MemberContributionsStatementDto;
import com.example.tujipange.contributionsService.repository.ContributionRepository;
import com.example.tujipange.user_management.repository.AppuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 19/05/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Slf4j
@Service
public class GetAllIndividualContributionService {
    //get all your contributions within a given span of time.
    //Start and end date else All records.
    //users should be able to download statements for their contributions that inner joins saved amount and merrygo amount.
    //Create a dto to achieve this
    //Here we will write a native sql query -> JPA

    private final  ContributionRepository contributionRepository;
    private final AppuserRepository appuserRepository;
    public GetAllIndividualContributionService(ContributionRepository contributionRepository,
                                               AppuserRepository appuserRepository) {
        this.contributionRepository = contributionRepository;
        this.appuserRepository = appuserRepository;
    }
    public List<MemberContributionsStatementDto> getIndividualMemberContributionsStatement(Long userId){
         appuserRepository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("User Id " +userId+ " Not found"));

         //get member contributions and savings
         List <MemberContributionsStatementDto> contributionList =
                 contributionRepository.findIndividualMemberContributions();

         return  contributionList;
//         return contributionList.stream()
//                 .map(contributions->ContributionMapperService.mapMemberContributionsDto(
//                 ))
//                 .collect(Collectors.toList());

    }
}
