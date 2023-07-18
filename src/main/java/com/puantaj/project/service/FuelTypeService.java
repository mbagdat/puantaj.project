package com.puantaj.project.service;

import com.puantaj.project.models.Acquisition;
import com.puantaj.project.models.FuelType;

import java.util.List;
import java.util.UUID;

public interface FuelTypeService {
    List<FuelType> getAllFuelTypes();

    FuelType getFuelTypeByGuid(UUID guid);

    FuelType createFuelType(FuelType fuelType);

    FuelType updateFuelType(UUID guid, FuelType updatedFuelType);

    void deleteFuelType(UUID guid);
}
