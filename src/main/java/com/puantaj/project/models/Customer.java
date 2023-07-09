package com.puantaj.project.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "customer_card_type")
    private int customerCardType;

    @Column(name = "customer_type")
    private int customerType;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "transport_type")
    private int transportType;

    @Column(name = "authorized_person")
    private String authorizedPerson;

    @Column(name = "optimistic_lockfield")
    private int optimisticLockfield;

    @Column(name = "gcrecord")
    private int gcrecord;

    @Column(name = "iban")
    private String iban;
}
