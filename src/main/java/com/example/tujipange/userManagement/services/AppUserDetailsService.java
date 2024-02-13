package com.example.tujipange.userManagement.services;

import com.example.tujipange.userManagement.dto.UserProfileResponse;

public interface AppUserDetailsService {
     UserProfileResponse getUseProfile(Long userId);
}
