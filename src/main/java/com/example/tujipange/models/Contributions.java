package com.example.tujipange.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contributions extends PO{
    @Column(name = "f_name", nullable = false)
    private String transactionCode; //generated code
    private BigDecimal paidAmount;
    private BigDecimal pendingBalance;
}
