package com.puantaj.project.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer_card_type")
public class CustomerCardType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    @Column(name = "customer_card_type_name")
    private String customerCardTypeName;

    public CustomerCardType() {
    }

    public CustomerCardType(String customerCardTypeName) {
        this.customerCardTypeName = customerCardTypeName;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getCustomerCardTypeName() {
        return customerCardTypeName;
    }

    public void setCustomerCardTypeName(String customerCardTypeName) {
        this.customerCardTypeName = customerCardTypeName;
    }
}
