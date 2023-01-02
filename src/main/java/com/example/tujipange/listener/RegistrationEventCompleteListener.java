package com.example.tujipange.listener;

import com.example.tujipange.events.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/2/23
 */
public class RegistrationEventCompleteListener
        implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create a verification Token for the user with the Link

        //Send Mail to the User
    }
}
