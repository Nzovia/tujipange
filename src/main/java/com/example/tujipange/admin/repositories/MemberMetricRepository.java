package com.example.tujipange.admin.repositories;

import com.example.tujipange.admin.models.MemberContributionMetric;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Nicholas Nzovia
 * @On 21/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public interface MemberMetricRepository extends JpaRepository<MemberContributionMetric, Long>{
    MemberContributionMetric findByMetricCode(String metricCode);
}
