package com.example.tujipange.admin.repositories;

import com.example.tujipange.admin.models.MemberContributionMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author Nicholas Nzovia
 * @On 21/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface MemberMetricRepository extends JpaRepository<MemberContributionMetric, Long>{
    MemberContributionMetric findByMetricCode(String metricCode);
}
