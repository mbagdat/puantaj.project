package com.puantaj.project.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guid")
    private UUID guid;

    @Column(name = "plateNo")
    private String plateNo;

    @Column(name = "name")
    private String name;

    @Column(name = "customerGuid")
    private UUID customerGuid;

    @Column(name = "acquisitionType")
    private int acquisitionType;

    @Column(name = "vehicleType")
    private int vehicleType;

    @Column(name = "fuelType")
    private int fuelType;

    @Column(name = "numberOfSeats")
    private int numberOfSeats;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "rentBeginDate")
    private LocalDateTime rentBeginDate;

    @Column(name = "rentEndDate")
    private LocalDateTime rentEndDate;

    @Column(name = "optimisticLockField")
    private int optimisticLockField;

    @Column(name = "model")
    private String model;

    @Column(name = "subCompanyVehicle")
    private boolean subCompanyVehicle;
}
