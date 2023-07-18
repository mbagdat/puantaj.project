package com.puantaj.project.models;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table(name = "acquisitions")
public class Acquisition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "acquisition")
    private String acquisition;
}
