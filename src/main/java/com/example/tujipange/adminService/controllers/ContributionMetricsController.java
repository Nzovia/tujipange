package com.example.tujipange.adminService.controllers;

import com.example.tujipange.adminService.dtos.ContributionMetricDto;
import com.example.tujipange.adminService.models.MemberContributionMetric;
import com.example.tujipange.adminService.services.MemberContributionMetricSetUp;
import com.example.tujipange.exceptions.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Api for setting up Group contribution metric")
    public ResponseEntity<String> addMemberContributionMetric(@RequestBody ContributionMetricDto contributionMetricDto) {
        memberContributionMetricSetUp.createContributionMetric(contributionMetricDto);
        return new ResponseEntity<>("Metric added Successfully", HttpStatus.OK);
    }

    @GetMapping("/metrics")
    @ApiOperation("Api for listing all Group contribution metric")
    public ResponseEntity<List> getAllContributionMetric(){
        var metrics = memberContributionMetricSetUp.getAllContributionMetrics();
        return ResponseEntity.ok(Collections.singletonList(metrics));
    };

    @PutMapping("/update_metrics/{id}")
    @ApiOperation("Api for updating Group contribution metric")
    public ResponseEntity<MemberContributionMetric>
    updateContributionMetric(@PathVariable(value = "id") Long metricId, @RequestBody ContributionMetricDto updateRequest) throws ResourceNotFoundException {
        MemberContributionMetric updatedContributionMetric = memberContributionMetricSetUp.updateContributionMetric(metricId, updateRequest);
        return new ResponseEntity<>(updatedContributionMetric, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Api for listing all Group contribution metric")
    public ResponseEntity<String> deleteContributionMetric(@PathVariable(value = "id") Long metricId) throws ResourceNotFoundException {
        memberContributionMetricSetUp.deleteContributionMetric(metricId);
        return new ResponseEntity<>("Metric Deleted Successfully",HttpStatus.OK);
    }


    //Todo. get active contribution metric by users
    @GetMapping("{status}")
    @ApiOperation("Api for listing all Group contribution metric")
    public ResponseEntity<?> getActiveContributionMetric(@PathVariable(value = "status") boolean status){
        return new ResponseEntity<>(memberContributionMetricSetUp.getActiveContributionMetric(status), HttpStatus.OK);
    }

    //Todo. activate contribution metric, note only one record in the metrics can be active at a time




}
