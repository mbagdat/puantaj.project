package com.puantaj.project.service;

import com.puantaj.project.models.NumberOfSeats;
import com.puantaj.project.repositories.NumberOfSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NumberOfSeatsServiceImpl implements NumberOfSeatsService {
    @Autowired
    NumberOfSeatsRepository numberOfSeatsRepository;

    @Override
    public NumberOfSeats createNumberOfSeats(NumberOfSeats numberOfSeats) {
        return numberOfSeatsRepository.save(numberOfSeats);
    }

    @Override
    public NumberOfSeats getNumberOfSeats(UUID guid) {
        return numberOfSeatsRepository.findById(guid).orElse(null);
    }

    @Override
    public List<NumberOfSeats> getAllNumberOfSeats() {
        return numberOfSeatsRepository.findAll();
    }

    @Override
    public NumberOfSeats updateNumberOfSeats(UUID guid, NumberOfSeats updatedNumberOfSeats) {
        NumberOfSeats existingNumberOfSeats = numberOfSeatsRepository.findById(guid).orElse(null);
        if (existingNumberOfSeats != null) {
            existingNumberOfSeats.setNumberOfSeats(updatedNumberOfSeats.getNumberOfSeats());
            return numberOfSeatsRepository.save(existingNumberOfSeats);
        }
        return null;
    }

    @Override
    public void deleteNumberOfSeats(UUID guid) {
        numberOfSeatsRepository.deleteById(guid);
    }

}
