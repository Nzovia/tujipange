package com.example.tujipange.userManagement.dto;

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
    private String  creationMessage;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String generatedToken, boolean error, String errorMessage, String creationMessage) {
        this.generatedToken = generatedToken;
        this.error = error;
        this.errorMessage = errorMessage;
        this.creationMessage = creationMessage;
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
        return new AuthenticationResponse(generatedToken, false, null,null);
    }

    public static AuthenticationResponse error(String errorMessage) {
        return new AuthenticationResponse(null, true, errorMessage,null);
    }
    public static AuthenticationResponse accountSuccess(String creationMessage){
        return new AuthenticationResponse(null, false, null,creationMessage);
    }

    public String getCreationMessage() {
        return creationMessage;
    }

    public void setCreationMessage(String creationMessage) {
        this.creationMessage = creationMessage;
    }
}
