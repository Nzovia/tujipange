package com.example.tujipange.user_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Data
@AllArgsConstructor
public class AppUserLoginRequest {
    private String userName;
    private String userPassword;
}
