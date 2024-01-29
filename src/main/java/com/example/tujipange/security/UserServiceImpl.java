package com.example.tujipange.security;

import com.example.tujipange.user_management.models.AppUser;
import com.example.tujipange.user_management.repository.AppuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicholas Nzovia
 * @On 25/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{
    private  final AppuserRepository appuserRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return appuserRepository.findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("user with "+username+" not found"));
            }

            private Set<SimpleGrantedAuthority> getAuthority(AppUser user) {
                Set<SimpleGrantedAuthority> authorities = new HashSet<>();
                user.getRoles().forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
                });
                return authorities;
            }
        };
    }


}
