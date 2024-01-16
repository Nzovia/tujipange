package com.example.tujipange.user_management.apis;

import com.example.tujipange.user_management.dto.AppUserDto;
import com.example.tujipange.user_management.dto.AppUserLoginRequest;
import com.example.tujipange.user_management.dto.AuthenticationResponse;
import com.example.tujipange.user_management.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

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
