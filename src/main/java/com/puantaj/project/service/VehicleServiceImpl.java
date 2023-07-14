package com.puantaj.project.service;


import com.puantaj.project.models.Vehicle;
import com.puantaj.project.repositories.VehicleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleByGuid(UUID guid) {
        return vehicleRepository.findById(guid).orElse(null);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(UUID guid, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(guid).orElse(null);
        if (existingVehicle != null) {
            BeanUtils.copyProperties(vehicle, existingVehicle);
            existingVehicle.setGuid(guid);
            return vehicleRepository.save(existingVehicle);
        }
        return null;
    }

    @Override
    public void deleteVehicle(UUID guid) {
        vehicleRepository.deleteById(guid);
    }
}
