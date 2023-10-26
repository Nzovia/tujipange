package com.example.tujipange.user_management.services;

import com.example.tujipange.user_management.dto.AppUserDto;
import com.example.tujipange.user_management.dto.AppUserLoginRequest;
import com.example.tujipange.user_management.dto.AuthenticationResponse;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface AuthenticationService {
    AuthenticationResponse createAccountUserAccount(AppUserDto signUpRequest);
    AuthenticationResponse signIn(AppUserLoginRequest loginRequest);

}
