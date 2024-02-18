package com.example.tujipange.adminService.services;

import com.example.tujipange.adminService.dtos.ContributionMetricDto;
import com.example.tujipange.adminService.models.MemberContributionMetric;
import com.example.tujipange.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 28/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface MemberContributionMetricSetUp {
     String createContributionMetric(ContributionMetricDto contributionMetricRequest);
     MemberContributionMetric updateContributionMetric(Long metricCode, ContributionMetricDto contributionMetricDto) throws ResourceNotFoundException;
    String deleteContributionMetric(Long metricId) throws ResourceNotFoundException;
    List<MemberContributionMetric> getAllContributionMetrics();
    Optional<ContributionMetricDto> getActiveContributionMetric(boolean active);

}
