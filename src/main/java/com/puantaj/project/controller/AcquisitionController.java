package com.puantaj.project.controller;


import com.puantaj.project.models.Acquisition;
import com.puantaj.project.service.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/acquisitions")
public class AcquisitionController {
    @Autowired
    AcquisitionService acquisitionService;


    @GetMapping
    public List<Acquisition> getAllAcquisitions() {
        return acquisitionService.getAllAcquisitions();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<Acquisition> getAcquisitionByGuid(@PathVariable UUID guid) {
        Acquisition acquisition = acquisitionService.getAcquisitionByGuid(guid);
        if (acquisition != null) {
            return new ResponseEntity<>(acquisition, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Acquisition> createAcquisition(@RequestBody Acquisition acquisition) {
        Acquisition createAcquisition = acquisitionService.createAcquisition(acquisition);
        return new ResponseEntity<>(createAcquisition, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<Acquisition> updateAcquisition(@PathVariable UUID guid, @RequestBody Acquisition updatedAcquisition) {
        Acquisition acquisition = acquisitionService.updateAcquisition(guid, updatedAcquisition);
        if (acquisition != null) {
            return new ResponseEntity<>(acquisition, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteAcquisition(@PathVariable UUID guid) {
        acquisitionService.deleteAcquisition(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
