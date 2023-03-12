package com.example.tujipange.user_management.models;

import com.example.tujipange.loanprocessing.models.Loan;
import com.example.tujipange.savingsService.models.Contributions;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "users",
uniqueConstraints = @UniqueConstraint(
//        name = {"unique_email","unique_phone"},
        columnNames = {"email_address", "phone_number"}
))
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "f_name", nullable = false)
    private String firstName = "Nicholas";
    @Column(name = "l_name", nullable = false)
    private String lastName = "Maundu";
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber = "0796182814";
    @Column(name = "email_address", nullable = false)
    private String email = "nickiemaundu@gmail.com";
    @Column(length = 60, name = "password")
    private String password;
    @Column(name ="user_role")
    private String role;
    private boolean enabled = false;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
    @OneToMany(mappedBy = "appUser")
    private Set<Contributions> contributions;
}
