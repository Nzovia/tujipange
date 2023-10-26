package com.example.tujipange.user_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private String generatedToken;
}
