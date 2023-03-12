package com.example.tujipange.user_management.repository;

import com.example.tujipange.user_management.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/2/23
 */

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
