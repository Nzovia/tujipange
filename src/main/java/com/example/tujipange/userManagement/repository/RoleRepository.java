package com.example.tujipange.userManagement.repository;

import com.example.tujipange.userManagement.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nicholas Nzovia
 * @On 29/01/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
