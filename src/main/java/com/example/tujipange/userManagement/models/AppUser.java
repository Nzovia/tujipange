package com.example.tujipange.userManagement.models;

import com.example.tujipange.loanProcessing.models.Loan;
import com.example.tujipange.contributionsService.models.IndividualContributions;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "users",
uniqueConstraints = @UniqueConstraint(
        columnNames = {"email_address", "phone_number"}
))
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "f_name", nullable = false)
    private String firstName;
    @Column(name = "l_name", nullable = false)
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email_address", nullable = false)
    private String email;
    @Column(length = 60, name = "password")
    private String password;

    @ManyToMany(mappedBy = "appUsers")
    private Set<Role> roles;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
    @OneToMany(mappedBy = "appUser")
    private Set<IndividualContributions> contributions;
    @Column(name = "enabled", nullable = false)
    private boolean enabled = false;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
