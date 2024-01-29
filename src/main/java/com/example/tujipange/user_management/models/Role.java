package com.example.tujipange.user_management.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicholas Nzovia
 * @On 29/01/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true,length = 50)
    private String roleName;

    @ManyToMany
    private Set<AppUser> userSet = new HashSet<>();

    public Role(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
