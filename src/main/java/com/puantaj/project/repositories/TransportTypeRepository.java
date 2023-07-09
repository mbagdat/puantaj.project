package com.puantaj.project.repositories;

import com.puantaj.project.models.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransportTypeRepository extends JpaRepository<TransportType, UUID> {
}
