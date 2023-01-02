package com.example.tujipange.user_management.models;

import com.example.tujipange.models.PO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Nzovia Maundu
 * @Contact: https://github.com/Nzovia
 * @since 1/2/23
 */

@Entity
@Data
@NoArgsConstructor
public class VerificationToken extends PO {
    private static  final int EXPIRATION_TIME =10 ;
    private String token;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "app_user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private AppUser appUser;

    public VerificationToken(String token, Date expirationTime, AppUser appUser) {
        super();
        this.token = token;
        this.expirationTime = calculateExpirationTime(EXPIRATION_TIME);  //10 minutes from the system time
        this.appUser = appUser;
    }

    public VerificationToken(String token, AppUser appUser) {
        this.token = token;
        this.appUser = appUser;
    }

    private Date calculateExpirationTime(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }

}
