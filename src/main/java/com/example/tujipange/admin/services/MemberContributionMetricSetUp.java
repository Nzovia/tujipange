package com.example.tujipange.admin.services;

import com.example.tujipange.admin.dtos.ContributionMetricDto;
import com.example.tujipange.admin.models.MemberContributionMetric;
import com.example.tujipange.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 28/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface MemberContributionMetricSetUp {
     String createContributionMetric(ContributionMetricDto contributionMetricRequest);
     MemberContributionMetric updateContributionMetric(Long metricCode, ContributionMetricDto contributionMetricDto);
    String deleteContributionMetric(Long metricId) throws ResourceNotFoundException;
    List<MemberContributionMetric> getAllContributionMetrics();

}
