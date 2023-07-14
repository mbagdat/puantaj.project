package com.puantaj.project.service;

import com.puantaj.project.models.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    Vehicle getVehicleByGuid(UUID guid);

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(UUID guid, Vehicle updatedVehicle);

    void deleteVehicle(UUID guid);
}
