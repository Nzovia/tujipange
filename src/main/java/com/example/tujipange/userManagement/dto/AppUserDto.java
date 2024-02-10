package com.example.tujipange.userManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
}
