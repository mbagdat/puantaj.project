package com.puantaj.project.service;

import com.puantaj.project.models.Acquisition;

import java.util.List;
import java.util.UUID;

public interface AcquisitionService {
    List<Acquisition> getAllAcquisitions();

    Acquisition getAcquisitionByGuid(UUID guid);

    Acquisition createAcquisition(Acquisition acquisition);

    Acquisition updateAcquisition(UUID guid, Acquisition updatedAcquisition);

    void deleteAcquisition(UUID guid);
}
