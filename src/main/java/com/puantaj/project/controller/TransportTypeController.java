package com.puantaj.project.controller;


import com.puantaj.project.models.CustomerType;
import com.puantaj.project.models.TransportType;
import com.puantaj.project.service.TransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transport-types")
public class TransportTypeController {
    @Autowired
    TransportTypeService transportTypeService;

    @GetMapping
    public List<TransportType> getAllCustomerTypes() {
        return transportTypeService.getAllTransportTypes();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<TransportType> getCustomerTypeByGuid(@PathVariable UUID guid) {
        TransportType transportType = transportTypeService.getTransportTypeByGuid(guid);
        if (transportType != null) {
            return new ResponseEntity<>(transportType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TransportType> createTransportType(@RequestBody TransportType transportType) {
        TransportType createTransportType = transportTypeService.createTransportType(transportType);
        return new ResponseEntity<>(createTransportType, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<TransportType> updateTransportType(@PathVariable UUID guid, @RequestBody TransportType updatedTransportType) {
        TransportType transportType = transportTypeService.updateTransportType(guid, updatedTransportType);
        if (transportType != null) {
            return new ResponseEntity<>(transportType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteTransportType(@PathVariable UUID guid) {
        transportTypeService.deleteTransportType(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
