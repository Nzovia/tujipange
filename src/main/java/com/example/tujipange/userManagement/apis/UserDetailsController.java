package com.example.tujipange.userManagement.apis;

import com.example.tujipange.userManagement.dto.UserProfileResponse;
import com.example.tujipange.userManagement.services.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/")
public class UserDetailsController {
    private final AppUserDetailsService appUserDetailsService;
    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable Long userId){
        var userProfile = appUserDetailsService.getUseProfile(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userProfile);
    }
}
