package com.example.tujipange.user_management.models;

import com.example.tujipange.models.PO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class AppUser extends PO {
    @Column(name = "f_name", nullable = false)
    private String firstName;
    @Column(name = "l_name", nullable = false)
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "email_number", nullable = false)
    private String email;
    @Column(length = 60, name = "password")
    private String password;
    @Column(name ="user_role")
    private String role;
    private boolean enabled = false;
}
