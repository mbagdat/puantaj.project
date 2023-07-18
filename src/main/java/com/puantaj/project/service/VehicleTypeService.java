package com.puantaj.project.service;

import com.puantaj.project.models.Acquisition;
import com.puantaj.project.models.VehicleType;

import java.util.List;
import java.util.UUID;

public interface VehicleTypeService {
    List<VehicleType> getAllVehicleType();

    VehicleType getVehicleTypeByGuid(UUID guid);

    VehicleType createVehicleType(VehicleType vehicleType);

    VehicleType updateVehicleType(UUID guid, VehicleType updatedVehicleType);

    void deleteVehicleType(UUID guid);
}
