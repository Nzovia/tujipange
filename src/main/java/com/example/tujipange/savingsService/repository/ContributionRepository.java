package com.example.tujipange.savingsService.repository;

import com.example.tujipange.savingsService.models.IndividualContributions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<IndividualContributions, Long> {
}
