package com.puantaj.project.controller;


import com.puantaj.project.models.NumberOfSeats;
import com.puantaj.project.service.NumberOfSeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/number-of-seats")
public class NumberOfSeatsController {

    @Autowired
    NumberOfSeatsService numberOfSeatsService;

    @PostMapping
    public ResponseEntity<NumberOfSeats> createNumberOfSeats(@RequestBody NumberOfSeats numberOfSeats) {
        NumberOfSeats createdNumberOfSeats = numberOfSeatsService.createNumberOfSeats(numberOfSeats);
        return new ResponseEntity<>(createdNumberOfSeats, HttpStatus.CREATED);
    }

    @GetMapping("/{guid}")
    public ResponseEntity<NumberOfSeats> getNumberOfSeats(@PathVariable("guid") UUID guid) {
        NumberOfSeats numberOfSeats = numberOfSeatsService.getNumberOfSeats(guid);
        if (numberOfSeats != null) {
            return new ResponseEntity<>(numberOfSeats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<NumberOfSeats>> getAllNumberOfSeats() {
        List<NumberOfSeats> allNumberOfSeats = numberOfSeatsService.getAllNumberOfSeats();
        return new ResponseEntity<>(allNumberOfSeats, HttpStatus.OK);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<NumberOfSeats> updateNumberOfSeats(@PathVariable("guid") UUID guid, @RequestBody NumberOfSeats updatedNumberOfSeats) {
        NumberOfSeats numberOfSeats = numberOfSeatsService.updateNumberOfSeats(guid, updatedNumberOfSeats);
        if (numberOfSeats != null) {
            return new ResponseEntity<>(numberOfSeats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteNumberOfSeats(@PathVariable("guid") UUID guid) {
        numberOfSeatsService.deleteNumberOfSeats(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
