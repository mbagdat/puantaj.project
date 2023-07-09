package com.puantaj.project.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "transport_types")
public class TransportType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "transport_type")
    private String transportType;

}
