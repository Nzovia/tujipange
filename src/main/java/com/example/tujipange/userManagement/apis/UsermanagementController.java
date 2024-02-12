package com.example.tujipange.userManagement.apis;

import com.example.tujipange.userManagement.dto.*;
import com.example.tujipange.userManagement.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class UsermanagementController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> createAccount(@RequestBody AppUserDto appUserDto) {
        var authResponse = authenticationService.createAccountUserAccount(appUserDto);
        return ResponseEntity.status(HttpStatus.OK).body(authResponse);
    }

    @PostMapping("/sign_in")
    public ResponseEntity<AuthenticationResponse> signInToYourAccount(@RequestBody AppUserLoginRequest loginRequest) {
        var loginResponse = authenticationService.signIn(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }
    //enable registered users for them to be able to access system
    @PostMapping("/enable_user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EnableUserResponse> enableOrDisableUserAccount(EnableRequest enableRequest){
        var enableUserResponse = authenticationService.enableOrDisableUseService(enableRequest);
        return ResponseEntity.status(HttpStatus.OK).body(enableUserResponse);
    }

    //Todo. get user profile api

    //Todo. update user details api . Only phone number and email can be updated

    //Todo. forgot password api

    //Todo. In case there is an existing user records you can import csv and map
    // them to the database ,two apis needed. Download csv template and import csv with user data


}
