package com.example.tujipange.userManagement.services;

import com.example.tujipange.security.jwt.JwtService;
import com.example.tujipange.userManagement.dto.AppUserDto;
import com.example.tujipange.userManagement.dto.AppUserLoginRequest;
import com.example.tujipange.userManagement.dto.AuthenticationResponse;
import com.example.tujipange.userManagement.models.AppUser;
import com.example.tujipange.userManagement.repository.AppuserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AppuserRepository appuserRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationServiceImpl(AppuserRepository appuserRepository,
                                     JwtService jwtService, AuthenticationManager
                                             authenticationManager,
                                     PasswordEncoder passwordEncoder) {
        this.appuserRepository = appuserRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticationResponse createAccountUserAccount(AppUserDto signUpRequest) {
        checkEmailAndPhoneNumberNotTaken(signUpRequest);

        AppUser appUser = new AppUser();
        appUser.setFirstName(signUpRequest.getFirstName());
        appUser.setLastName(signUpRequest.getLastName());
        appUser.setPhoneNumber(signUpRequest.getPhoneNumber());
        appUser.setEmail(signUpRequest.getEmail());
//        appUser.setRole();
        appUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        appuserRepository.save(appUser);
        String message = "Account Created Successfully";

        return AuthenticationResponse.accountSuccess(message);
    }

    @Override
    public AuthenticationResponse signIn(AppUserLoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                            loginRequest.getUserPassword()));

            var loggedInUser = appuserRepository.findByEmail(loginRequest.getUserName())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
            var jwtToken = jwtService.generateToken(loggedInUser.getUsername());

            return AuthenticationResponse.success(jwtToken);
        } catch (Exception e) {
            // Return an error response
            e.printStackTrace();
            return AuthenticationResponse.error("Authentication failed: " + e.getMessage());
        }
    }


    private void checkEmailAndPhoneNumberNotTaken(AppUserDto appUserDto) {

        //check if the email or phone number already exists
        if(appuserRepository.existsByEmail(appUserDto.getEmail()) ||
                appuserRepository.existsByPhoneNumber(appUserDto.getPhoneNumber())){

            //handle the case when email and phoneNumber already exists
            throw new IllegalArgumentException("Email or Phone number is already taken");
        }
    }
}