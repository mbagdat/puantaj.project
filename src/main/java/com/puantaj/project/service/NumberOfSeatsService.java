package com.puantaj.project.service;

import com.puantaj.project.models.NumberOfSeats;

import java.util.List;
import java.util.UUID;

public interface NumberOfSeatsService {
    NumberOfSeats createNumberOfSeats(NumberOfSeats numberOfSeats);

    NumberOfSeats getNumberOfSeats(UUID guid);

    List<NumberOfSeats> getAllNumberOfSeats();

    NumberOfSeats updateNumberOfSeats(UUID guid, NumberOfSeats updatedNumberOfSeats);

    void deleteNumberOfSeats(UUID guid);
}
