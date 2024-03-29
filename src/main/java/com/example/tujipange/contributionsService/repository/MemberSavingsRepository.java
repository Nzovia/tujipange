package com.example.tujipange.contributionsService.repository;

import com.example.tujipange.contributionsService.models.MemberSavings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nicholas Nzovia
 * @On 22/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@Repository
public interface MemberSavingsRepository extends JpaRepository<MemberSavings, Long> {
}
