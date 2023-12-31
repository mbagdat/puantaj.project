package com.puantaj.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "customer_card_types")
public class CustomerCardType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "customer_card_type_name")
    private String customerCardTypeName;


}
