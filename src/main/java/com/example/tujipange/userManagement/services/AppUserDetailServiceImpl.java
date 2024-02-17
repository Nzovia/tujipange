package com.example.tujipange.userManagement.services;

import com.example.tujipange.security.jwt.JwtService;
import com.example.tujipange.userManagement.dto.UpdateProfileRequest;
import com.example.tujipange.userManagement.dto.UserProfileResponse;
import com.example.tujipange.userManagement.repository.AppuserRepository;
import com.example.tujipange.utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class AppUserDetailServiceImpl implements AppUserDetailsService {
    private final AppuserRepository appuserRepository;
    private final JwtService jwtService;

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

    @Override
    public ResponseEntity<Object> updateProfile(Long userId, UpdateProfileRequest request) {
        if (!appuserRepository.existsById(userId)) {
            return ResponseHandler.generateResponse("User not found", HttpStatus.NOT_FOUND, null);
        }
        var appUser = appuserRepository.getById(userId);
        appUser.setEmail(request.getEmail());
        appUser.setPhoneNumber(request.getPhoneNumber());
        appuserRepository.save(appUser);
        Map<String,Object> responseObj = new HashMap<>();
        var newToken = jwtService.generateToken(request.getEmail());
        responseObj.put("token", newToken);
        return ResponseHandler.generateResponse("Your profile has been updated", HttpStatus.OK, responseObj);
    }
}
