package com.example.tujipange.userManagement.dto;

/**
 * @author Nicholas Nzovia
 * @On 26/10/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

public class AppUserLoginRequest {
    private String userName;
    private String userPassword;

    public AppUserLoginRequest() {
    }
    public AppUserLoginRequest(String userName,
                               String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
