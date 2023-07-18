package com.puantaj.project.repositories;

import com.puantaj.project.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, UUID> {
}
