package com.example.tujipange.events.listener;

import com.example.tujipange.events.RegistrationCompleteEvent;
import com.example.tujipange.user_management.models.AppUser;
import com.example.tujipange.user_management.services.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/2/23
 */

@Slf4j
public class RegistrationEventCompleteListener
        implements ApplicationListener<RegistrationCompleteEvent> {

    private final AppUserService appUserService;
    public RegistrationEventCompleteListener(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        //Create a verification Token for the user with the Link
        AppUser appUser = event.getAppUser();
        String token = UUID.randomUUID().toString();
        appUserService.saveVerificationTokenForAppUser(appUser,token);

        //Send Mail to the User
        String url = event.getApplicationUrl()
                + "verifyRegistration?token"
                + token;

        //calling email method here
        //sendVerificationEmail();
        log.info("Click the link to verify your account: {}", url);
    }
}
