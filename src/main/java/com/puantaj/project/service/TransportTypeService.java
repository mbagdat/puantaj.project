package com.puantaj.project.service;

import com.puantaj.project.models.TransportType;

import java.util.List;
import java.util.UUID;

public interface TransportTypeService {

    List<TransportType> getAllTransportTypes();

    TransportType getTransportTypeByGuid(UUID guid);

    TransportType createTransportType(TransportType transportType);

    TransportType updateTransportType(UUID guid, TransportType updatedTransportType);

    void deleteTransportType(UUID guid);
}
