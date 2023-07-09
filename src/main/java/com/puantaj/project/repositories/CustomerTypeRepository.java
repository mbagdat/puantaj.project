package com.puantaj.project.repositories;

import com.puantaj.project.models.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, UUID> {
}
