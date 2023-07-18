package com.puantaj.project.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "vehicleTypes")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "vehicleType")
    private String vehicleType;
}
