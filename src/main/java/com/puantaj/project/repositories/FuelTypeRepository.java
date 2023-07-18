package com.puantaj.project.repositories;

import com.puantaj.project.models.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelTypeRepository extends JpaRepository<FuelType, UUID> {
}
