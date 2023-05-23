package com.example.tujipange.contributionsService.controllers;

import com.example.tujipange.contributionsService.dtos.MemberContributionsRequest;
import com.example.tujipange.contributionsService.dtos.MemberContributionsStatementDto;
import com.example.tujipange.contributionsService.models.IndividualContributions;
import com.example.tujipange.contributionsService.services.ContributionsService;
import com.example.tujipange.contributionsService.services.GetAllIndividualContributionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ContributionsController {
    private final ContributionsService contributionsService;
    private final GetAllIndividualContributionService getAllIndividualContributionService;
    public ContributionsController(ContributionsService contributionsService,
                                   GetAllIndividualContributionService getAllIndividualContributionService) {
        this.contributionsService = contributionsService;
        this.getAllIndividualContributionService = getAllIndividualContributionService;
    }

    //make contributions
    @PostMapping("/contributions/{userId}")
    @ApiOperation("This is a POST method for users to make contributions to their savings wallet")
    @ResponseStatus(HttpStatus.OK)
    public void makeContributions(@RequestBody MemberContributionsRequest request, @PathVariable Long userId){
        contributionsService.makeContributions(request, userId);
    }

    //update contributions

    //get all contributions
    @GetMapping("contributions")
    @ApiOperation("This is a GET method to list all the contributions made by the group members")
    @ResponseStatus(HttpStatus.OK)
    public List<IndividualContributions> getAllContributions(){
        List<IndividualContributions> contributions = contributionsService.getAllMemberContributions();
        return contributions;
    }

    @GetMapping("contributionsStatement/{userId}")
    @ApiOperation("This is a GET method to list all the contributions by an individual member")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberContributionsStatementDto> getIndividualContributionStatement(@PathVariable Long userId){
        List<MemberContributionsStatementDto> contributions =
                getAllIndividualContributionService.getIndividualMemberContributionsStatement(userId);
        return contributions;
    }
}
