package com.example.tujipange.savingsService.controllers;

import com.example.tujipange.savingsService.controllers.requests.MemberContributionsRequest;
import com.example.tujipange.savingsService.models.Contributions;
import com.example.tujipange.savingsService.services.ContributionsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/contributions")
public class ContributionsController {
    private final ContributionsService contributionsService;
    public ContributionsController(ContributionsService contributionsService) {
        this.contributionsService = contributionsService;
    }

    //make contributions
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void makeContributions(@RequestBody MemberContributionsRequest request){
        contributionsService.makeContributions(request);
    }

    //update contributions

    //get contributions
}
