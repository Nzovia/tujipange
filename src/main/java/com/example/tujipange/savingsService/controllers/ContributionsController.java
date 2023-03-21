package com.example.tujipange.savingsService.controllers;

import com.example.tujipange.savingsService.dtos.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.Contributions;
import com.example.tujipange.savingsService.services.ContributionsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contributions")
public class ContributionsController {
    private final ContributionsService contributionsService;
    public ContributionsController(ContributionsService contributionsService) {
        this.contributionsService = contributionsService;
    }

    //make contributions
    @PostMapping
    @ApiOperation("This is a POST method for users to make contributions to their savings wallet")
    @ResponseStatus(HttpStatus.OK)
    public void makeContributions(@RequestBody MemberContributionsRequest request){
        contributionsService.makeContributions(request);
    }

    //update contributions

    //get all contributions
    @GetMapping
    @ApiOperation("This is a GET method to list all the contributions made by the group members")
    @ResponseStatus(HttpStatus.OK)
    public List<Contributions> getAllContributions(){
        List<Contributions> contributions = contributionsService.getAllMemberContributions();
        return contributions;
    }
}
