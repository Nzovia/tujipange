package com.example.tujipange.userManagement.services;

import com.example.tujipange.userManagement.dto.*;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface AuthenticationService {
    AuthenticationResponse createAccountUserAccount(AppUserDto signUpRequest);
    AuthenticationResponse signIn(AppUserLoginRequest loginRequest);
    EnableUserResponse enableOrDisableUseService(EnableRequest enableRequest);
}
