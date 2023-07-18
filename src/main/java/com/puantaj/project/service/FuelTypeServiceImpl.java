package com.puantaj.project.service;

import com.puantaj.project.models.FuelType;
import com.puantaj.project.repositories.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuelTypeServiceImpl implements FuelTypeService{

    @Autowired
    FuelTypeRepository fuelTypeRepository;
    @Override
    public List<FuelType> getAllFuelTypes() {
        return fuelTypeRepository.findAll();
    }

    @Override
    public FuelType getFuelTypeByGuid(UUID guid) {
        return fuelTypeRepository.findById(guid).orElse(null);
    }

    @Override
    public FuelType createFuelType(FuelType fuelType) {
        return fuelTypeRepository.save(fuelType);
    }

    @Override
    public FuelType updateFuelType(UUID guid, FuelType updatedFuelType) {
        Optional<FuelType> existingFuelType = fuelTypeRepository.findById(guid);
        if (existingFuelType.isPresent()) {
            FuelType fuelType = existingFuelType.get();
            fuelType.setFuelType(updatedFuelType.getFuelType());
            return fuelTypeRepository.save(fuelType);
        }
        return null;
    }

    @Override
    public void deleteFuelType(UUID guid) {
        fuelTypeRepository.deleteById(guid);
    }
}
