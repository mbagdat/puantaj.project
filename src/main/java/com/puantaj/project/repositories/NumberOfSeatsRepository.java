package com.puantaj.project.repositories;

import com.puantaj.project.models.NumberOfSeats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NumberOfSeatsRepository extends JpaRepository<NumberOfSeats, UUID> {
}
