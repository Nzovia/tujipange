package com.example.tujipange.userManagement.services;

import com.example.tujipange.userManagement.dto.UpdateProfileRequest;
import com.example.tujipange.userManagement.dto.UserProfileResponse;
import org.springframework.http.ResponseEntity;

public interface AppUserDetailsService {
     UserProfileResponse getUseProfile(Long userId);

    ResponseEntity<Object> updateProfile(Long userId, UpdateProfileRequest request);
}
