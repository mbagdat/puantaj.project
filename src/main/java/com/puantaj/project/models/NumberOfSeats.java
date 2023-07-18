package com.puantaj.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "number_of_seats")
public class NumberOfSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "number_of_seats")
    private String numberOfSeats;

}
