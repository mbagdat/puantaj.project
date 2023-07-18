package com.puantaj.project.controller;


import com.puantaj.project.models.VehicleType;
import com.puantaj.project.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicleTypes")
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @GetMapping
    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeService.getAllVehicleType();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<VehicleType> getVehicleTypeByGuid(@PathVariable UUID guid) {
        VehicleType vehicleType = vehicleTypeService.getVehicleTypeByGuid(guid);
        if (vehicleType != null) {
            return new ResponseEntity<>(vehicleType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VehicleType> createVehicleType(@RequestBody VehicleType vehicleType) {
        VehicleType createVehicle = vehicleTypeService.createVehicleType(vehicleType);
        return new ResponseEntity<>(createVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<VehicleType> updateVehicleType(@PathVariable UUID guid, @RequestBody VehicleType updatedVehicleType) {
        VehicleType vehicleType = vehicleTypeService.updateVehicleType(guid, updatedVehicleType);
        if (vehicleType != null) {
            return new ResponseEntity<>(vehicleType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteVehicleType(@PathVariable UUID guid) {
        vehicleTypeService.deleteVehicleType(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
