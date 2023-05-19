package com.example.tujipange.savingsService.repository;

import com.example.tujipange.savingsService.models.MerryGoRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nicholas Nzovia
 * @On 22/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface MemberSharingRepository extends JpaRepository<MerryGoRound, Long> {
}
