package com.puantaj.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "model")
    private String model;
}
