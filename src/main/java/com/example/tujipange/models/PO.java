package com.example.tujipange.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
public class PO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
