package com.puantaj.project.service;

import com.puantaj.project.models.Acquisition;
import com.puantaj.project.repositories.AcquisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AcquisitionServiceImpl implements AcquisitionService {

    @Autowired
    AcquisitionRepository acquisitionRepository;

    @Override
    public List<Acquisition> getAllAcquisitions() {
        return acquisitionRepository.findAll();
    }

    @Override
    public Acquisition getAcquisitionByGuid(UUID guid) {
        return acquisitionRepository.findById(guid).orElse(null);
    }

    @Override
    public Acquisition createAcquisition(Acquisition acquisition) {
        return acquisitionRepository.save(acquisition);
    }

    @Override
    public Acquisition updateAcquisition(UUID guid, Acquisition updatedAcquisition) {
        Optional<Acquisition> existingCustomerType = acquisitionRepository.findById(guid);
        if (existingCustomerType.isPresent()) {
            Acquisition acquisition = existingCustomerType.get();
            acquisition.setAcquisition(updatedAcquisition.getAcquisition());
            return acquisitionRepository.save(acquisition);
        }
        return null;
    }

    @Override
    public void deleteAcquisition(UUID guid) {
        acquisitionRepository.deleteById(guid);
    }
}
