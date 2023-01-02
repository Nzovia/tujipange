package com.example.tujipange.events;

import com.example.tujipange.user_management.models.AppUser;
import org.springframework.context.ApplicationEvent;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/2/23
 */
public class RegistrationCompleteEvent extends ApplicationEvent {
    private AppUser appUser;
    private String applicationUrl;
    public RegistrationCompleteEvent(AppUser appUser, String applicationUrl) {
        super(appUser);
        this.appUser = appUser;
        this.applicationUrl = applicationUrl;
    }
}
