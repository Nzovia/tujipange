package com.example.tujipange.security;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Nicholas Nzovia
 * @On 25/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface UserService {
    UserDetailsService userDetailsService();
}
