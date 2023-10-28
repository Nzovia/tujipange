package com.example.tujipange.user_management.apis;

import com.example.tujipange.user_management.dto.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/1/23
 */

@RestController
public class UsermanagementController {


    //events triggered on creating account
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/register")
    public String createAccount(@RequestBody AppUserDto appUserDto, final HttpServletRequest request){ //to get the context of the url you will need to use Http request
     return "";
    }
}
