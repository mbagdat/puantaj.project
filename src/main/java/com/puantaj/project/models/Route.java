package com.puantaj.project.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID guid;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "person_in_charge")
    private String personInCharge;

    @Column(name = "max_price_weekday")
    private float maxPriceWeekday;

    @Column(name = "max_price_weekend")
    private float maxPriceWeekend;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "optimistic_lock_field")
    private int optimisticLockField;

    @Column(name = "gcrecord")
    private int gcrecord;

    @Column(name = "hostess")
    private boolean hostess;

    @Column(name = "person_in_chage")
    private String personInChage;

}
