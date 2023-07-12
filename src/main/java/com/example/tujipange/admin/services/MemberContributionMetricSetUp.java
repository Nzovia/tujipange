package com.example.tujipange.admin.services;

import com.example.tujipange.admin.dtos.ContributionMetricDto;
import com.example.tujipange.admin.models.MemberContributionMetric;

import java.util.Collection;

/**
 * @author Nicholas Nzovia
 * @On 28/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface MemberContributionMetricSetUp {
    public abstract String createContributionMetric(ContributionMetricDto contributionMetricRequest);
    public abstract void updateContributionMetric(ContributionMetricDto contributionMetricDto);
    public abstract void deleteContributionMetric();
    public abstract Collection<MemberContributionMetric> getAllContributionMetrics();

}
