package com.example.tujipange.userManagement.services;

import com.example.tujipange.userManagement.dto.UserProfileResponse;
import com.example.tujipange.userManagement.repository.AppuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AppUserDetailServiceImpl implements AppUserDetailsService {
    private final AppuserRepository appuserRepository;

    @Override
    public UserProfileResponse getUseProfile(Long userId) {
        if (!appuserRepository.existsById(userId)){
            return UserProfileResponse.error("User not found");
        }
        var appUser = appuserRepository.getById(userId);
        return UserProfileResponse.success(
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getEmail(),
                appUser.getPhoneNumber()
        );
    }
}
