package com.puantaj.project.repositories;

import com.puantaj.project.models.Acquisition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcquisitionRepository extends JpaRepository<Acquisition, UUID> {
}
