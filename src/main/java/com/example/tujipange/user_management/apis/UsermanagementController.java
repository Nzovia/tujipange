package com.example.tujipange.user_management.apis;

import com.example.tujipange.events.RegistrationCompleteEvent;
import com.example.tujipange.user_management.dto.AppUserDto;
import com.example.tujipange.user_management.models.AppUser;
import com.example.tujipange.user_management.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@RestController
public class UsermanagementController {

    @Autowired
    private AppUserService appUserService;

    //events triggered on creating account
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/register")
    public String createAccount(@RequestBody AppUserDto appUserDto){
        AppUser appUser = appUserService.createAccountUserAccount(appUserDto);
        eventPublisher.publishEvent(new RegistrationCompleteEvent(
                appUser,
                "url"
        ));
        return "Account Created Successfully";
    }
}
