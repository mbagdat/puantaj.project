package com.puantaj.project.service;

import com.puantaj.project.models.Model;

import java.util.List;
import java.util.UUID;

public interface ModelService {

    List<Model> getAllModels();

    Model getModelByGuid(UUID guid);

    Model createModel(Model model);

    Model updateModel(UUID guid, Model updatedModel);

    void deleteModel(UUID guid);
}
