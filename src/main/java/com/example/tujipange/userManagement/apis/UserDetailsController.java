package com.example.tujipange.userManagement.apis;

import com.example.tujipange.userManagement.dto.UpdateProfileRequest;
import com.example.tujipange.userManagement.dto.UserProfileResponse;
import com.example.tujipange.userManagement.services.AppUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/profile/update/{userId}")
    public ResponseEntity<Object> updateProfile(@PathVariable Long userId, @RequestBody UpdateProfileRequest request){
        return appUserDetailsService.updateProfile(userId, request);
    }
}
