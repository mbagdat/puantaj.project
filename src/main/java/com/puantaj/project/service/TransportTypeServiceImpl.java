package com.puantaj.project.service;

import com.puantaj.project.models.TransportType;
import com.puantaj.project.repositories.TransportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransportTypeServiceImpl implements TransportTypeService {

    @Autowired
    TransportTypeRepository transportTypeRepository;

    @Override
    public List<TransportType> getAllTransportTypes() {
        return transportTypeRepository.findAll();
    }

    @Override
    public TransportType getTransportTypeByGuid(UUID guid) {
        return transportTypeRepository.findById(guid).orElse(null);
    }

    @Override
    public TransportType createTransportType(TransportType transportType) {
        return transportTypeRepository.save(transportType);
    }

    @Override
    public TransportType updateTransportType(UUID guid, TransportType updatedTransportType) {
        Optional<TransportType> existingTransportType = transportTypeRepository.findById(guid);
        if (existingTransportType.isPresent()) {
            TransportType transportType = existingTransportType.get();
            transportType.setTransportType(updatedTransportType.getTransportType());
            return transportTypeRepository.save(transportType);
        }
        return null;
    }

    @Override
    public void deleteTransportType(UUID guid) {
       transportTypeRepository.deleteById(guid);
    }
}
