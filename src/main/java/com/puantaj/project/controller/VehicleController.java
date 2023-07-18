package com.puantaj.project.controller;

import com.puantaj.project.models.Vehicle;
import com.puantaj.project.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @GetMapping("/{guid}")
    public ResponseEntity<Vehicle> getVehicleByGuid(@PathVariable("guid") UUID guid) {
        Vehicle vehicle = vehicleService.getVehicleByGuid(guid);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PutMapping("/{guid}")
    public ResponseEntity<Vehicle> updateVehicle(
            @PathVariable("guid") UUID guid,
            @RequestBody Vehicle vehicle
    ) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(guid, vehicle);
        if (updatedVehicle != null) {
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("guid") UUID guid) {
        vehicleService.deleteVehicle(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
