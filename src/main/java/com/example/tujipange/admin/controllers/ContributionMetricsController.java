package com.example.tujipange.admin.controllers;

import com.example.tujipange.admin.dtos.ContributionMetricDto;
import com.example.tujipange.admin.repositories.MemberMetricRepository;
import com.example.tujipange.admin.services.MemberContributionMetricSetUpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nicholas Nzovia
 * @On 21/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/")
public class ContributionMetricsController {
    @Autowired
    private MemberContributionMetricSetUpImpl memberContributionMetricSetUp;

    @PostMapping("/addContributionMetric")
    public ResponseEntity<String> addMemberContributionMetric(ContributionMetricDto contributionMetricDto) {
        memberContributionMetricSetUp.createContributionMetric(contributionMetricDto);
        return new ResponseEntity<>("Product Created Successfully", HttpStatus.OK);
    }




}
