package com.puantaj.project.controller;


import com.puantaj.project.models.FuelType;
import com.puantaj.project.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fuelTypes")
public class FuelTypeController {

    @Autowired
    FuelTypeService fuelTypeService;


    @GetMapping
    public List<FuelType> getAllFuelTypes() {
        return fuelTypeService.getAllFuelTypes();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<FuelType> getFuelTypeByGuid(@PathVariable UUID guid) {
        FuelType fuelType = fuelTypeService.getFuelTypeByGuid(guid);
        if (fuelType != null) {
            return new ResponseEntity<>(fuelType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<FuelType> createFuelType(@RequestBody FuelType fuelType) {
        FuelType createFuelType = fuelTypeService.createFuelType(fuelType);
        return new ResponseEntity<>(createFuelType, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<FuelType> updateFuelType(@PathVariable UUID guid, @RequestBody FuelType updatedFuelType) {
        FuelType fuelType = fuelTypeService.updateFuelType(guid, updatedFuelType);
        if (fuelType != null) {
            return new ResponseEntity<>(fuelType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteFuelType(@PathVariable UUID guid) {
        fuelTypeService.deleteFuelType(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
