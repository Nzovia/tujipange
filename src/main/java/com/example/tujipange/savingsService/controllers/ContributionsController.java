package com.example.tujipange.savingsService.controllers;

import com.example.tujipange.savingsService.controllers.requests.MakeContributionsRequest;
import com.example.tujipange.savingsService.services.ContributionsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ContributionsController {
    private final ContributionsService contributionsService;
    public ContributionsController(ContributionsService contributionsService) {
        this.contributionsService = contributionsService;
    }

    //make contributions
    @PostMapping
    public void makeContributions(MakeContributionsRequest request){
        contributionsService.makeContributions(request);

    }

    //update contributions

    //get contributions
}
