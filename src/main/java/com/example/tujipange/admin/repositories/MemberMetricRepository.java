package com.example.tujipange.admin.repositories;

import com.example.tujipange.admin.entities.MemberContributionMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Nicholas Nzovia
 * @On 21/06/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface MemberMetricRepository extends JpaRepository<MemberContributionMetric, Long>{
}
