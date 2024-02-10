package com.example.tujipange.userManagement.apis;

import com.example.tujipange.userManagement.dto.AppUserDto;
import com.example.tujipange.userManagement.dto.AppUserLoginRequest;
import com.example.tujipange.userManagement.dto.AuthenticationResponse;
import com.example.tujipange.userManagement.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
