package com.example.tujipange.user_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Builder
public class AuthenticationResponse {
    private String generatedToken;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String generatedToken) {
        this.generatedToken = generatedToken;
    }

    public String getGeneratedToken() {
        return generatedToken;
    }

    public void setGeneratedToken(String generatedToken) {
        this.generatedToken = generatedToken;
    }
}
