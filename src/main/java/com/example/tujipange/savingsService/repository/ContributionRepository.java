package com.example.tujipange.savingsService.repository;

import com.example.tujipange.savingsService.models.Contributions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contributions, Long> {
}
