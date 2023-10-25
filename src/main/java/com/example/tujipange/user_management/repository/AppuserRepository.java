package com.example.tujipange.user_management.repository;

import com.example.tujipange.user_management.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@Repository
public interface AppuserRepository extends JpaRepository<AppUser, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<AppUser> findByEmail(String username);
}
