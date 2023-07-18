package com.puantaj.project.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "fuel_types")
public class FuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "fuelType")
    private String fuelType;
}
