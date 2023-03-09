package com.example.tujipange.user_management.services;

import com.example.tujipange.user_management.dto.AppUserDto;
import com.example.tujipange.user_management.models.AppUser;
import com.example.tujipange.user_management.models.VerificationToken;
import com.example.tujipange.user_management.repository.AppuserRepository;
import com.example.tujipange.user_management.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@Service
public class AppUserImplService implements AppUserService{
    @Autowired
    private AppuserRepository appuserRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Override
    public AppUser createAccountUserAccount(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        appUser.setFirstName(appUserDto.getFirstName());
        appUser.setLastName(appUserDto.getLastName());
        appUser.setPhoneNumber(appUserDto.getPhoneNumber());
        appUser.setEmail(appUserDto.getEmail());
//        appUser.setRole("USER");
//        appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));

        //validating password
        appuserRepository.save(appUser);

        return appUser;
    }

    @Override
    public void saveVerificationTokenForAppUser(AppUser appUser, String token) {
        VerificationToken verificationToken = new VerificationToken(token, appUser);
        verificationTokenRepository.save(verificationToken);


    }
}
