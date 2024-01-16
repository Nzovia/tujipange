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
    private boolean error;
    private String errorMessage;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String generatedToken, boolean error, String errorMessage) {
        this.generatedToken = generatedToken;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public String getGeneratedToken() {
        return generatedToken;
    }

    public void setGeneratedToken(String generatedToken) {
        this.generatedToken = generatedToken;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static AuthenticationResponse success(String generatedToken) {
        return new AuthenticationResponse(generatedToken, false, null);
    }

    public static AuthenticationResponse error(String errorMessage) {
        return new AuthenticationResponse(null, true, errorMessage);
    }
}
