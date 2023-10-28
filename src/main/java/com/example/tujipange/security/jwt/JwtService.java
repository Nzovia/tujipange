package com.example.tujipange.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Nicholas Nzovia
 * @On 25/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface JwtService {
    String extractUserNameFromToken(String token);
    String generateJWTToken(UserDetails userDetails);
    boolean isJWTTokenValid(String token, UserDetails userDetails);
}
