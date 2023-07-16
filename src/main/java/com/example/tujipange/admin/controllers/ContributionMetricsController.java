package com.example.tujipange.admin.controllers;

import com.example.tujipange.admin.dtos.ContributionMetricDto;
import com.example.tujipange.admin.models.MemberContributionMetric;
import com.example.tujipange.admin.services.MemberContributionMetricSetUp;
import com.example.tujipange.admin.services.MemberContributionMetricSetUpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 21/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/")
public class ContributionMetricsController {
    @Autowired
    private MemberContributionMetricSetUp memberContributionMetricSetUp;
    @PostMapping("/addContributionMetric")
    public ResponseEntity<String> addMemberContributionMetric(@RequestBody ContributionMetricDto contributionMetricDto) {
        memberContributionMetricSetUp.createContributionMetric(contributionMetricDto);
        return new ResponseEntity<>("Metric added Successfully", HttpStatus.OK);
    }

    @GetMapping("/metrics")
    public ResponseEntity<List> getAllContributionMetric(){
        var metrics = memberContributionMetricSetUp.getAllContributionMetrics();
        return ResponseEntity.ok(Collections.singletonList(metrics));
    };

    @PutMapping("/update_metrics/{id}")
    public ResponseEntity<MemberContributionMetric> updateContributionMetric(@PathVariable("id") Long metricId, @RequestBody ContributionMetricDto updateRequest){
        MemberContributionMetric updatedContributionMetric = memberContributionMetricSetUp.updateContributionMetric(metricId, updateRequest);
        return new ResponseEntity<>(updatedContributionMetric, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContributionMetric(@PathVariable("id") Long metricId){
        memberContributionMetricSetUp.deleteContributionMetric(metricId);
        return new ResponseEntity<>("Metric Deleted Successfully",HttpStatus.OK);
    }



}
