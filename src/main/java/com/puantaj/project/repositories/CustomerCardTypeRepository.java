package com.puantaj.project.repositories;

import com.puantaj.project.models.CustomerCardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerCardTypeRepository extends JpaRepository<CustomerCardType, UUID> {
}
