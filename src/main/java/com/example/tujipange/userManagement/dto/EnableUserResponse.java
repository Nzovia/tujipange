package com.example.tujipange.userManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 11/02/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnableUserResponse {
    private String enableMessage;

    public static EnableUserResponse enabledUserSuccess(String enableMessage) {
        return new EnableUserResponse(enableMessage);
    }
}
