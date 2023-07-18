package com.puantaj.project.service;

import com.puantaj.project.models.Acquisition;
import com.puantaj.project.models.VehicleType;
import com.puantaj.project.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<VehicleType> getAllVehicleType() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public VehicleType getVehicleTypeByGuid(UUID guid) {
        return vehicleTypeRepository.findById(guid).orElse(null);
    }

    @Override
    public VehicleType createVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public VehicleType updateVehicleType(UUID guid, VehicleType updatedVehicleType) {
        Optional<VehicleType> existingVehicleType = vehicleTypeRepository.findById(guid);
        if (existingVehicleType.isPresent()) {
            VehicleType vehicleType = existingVehicleType.get();
            vehicleType.setVehicleType(updatedVehicleType.getVehicleType());
            return vehicleTypeRepository.save(vehicleType);
        }
        return null;
    }

    @Override
    public void deleteVehicleType(UUID guid) {
        vehicleTypeRepository.deleteById(guid);
    }
}
