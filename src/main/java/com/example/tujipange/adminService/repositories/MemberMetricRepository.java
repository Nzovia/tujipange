package com.example.tujipange.adminService.repositories;

import com.example.tujipange.adminService.dtos.ContributionMetricDto;
import com.example.tujipange.adminService.models.MemberContributionMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * @author Nicholas Nzovia
 * @On 21/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public interface MemberMetricRepository extends JpaRepository<MemberContributionMetric, Long>{
    MemberContributionMetric findByMetricCode(String metricCode);

    Optional<ContributionMetricDto> findByStatus(boolean active);
}
