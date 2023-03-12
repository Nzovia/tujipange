package com.example.tujipange.user_management.services;

import com.example.tujipange.user_management.dto.AppUserDto;
import com.example.tujipange.user_management.models.AppUser;
import org.springframework.stereotype.Service;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@Service
public interface AppUserService {
    AppUser createAccountUserAccount(AppUserDto appUserDto);

    void saveVerificationTokenForAppUser(AppUser appUser, String token);
}
