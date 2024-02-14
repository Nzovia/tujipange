package com.example.tujipange.userManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String errorMessage;

    public static UserProfileResponse success(String firstName, String lastName, String phoneNumber, String email) {
        return new UserProfileResponse(
                firstName, lastName, phoneNumber, email,null
        );
    }

    public static UserProfileResponse error(String errorMessage){
        return new UserProfileResponse(
                null,null, null, null, errorMessage
        );
    }
}
