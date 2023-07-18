package com.puantaj.project.service;

import com.puantaj.project.models.Model;
import com.puantaj.project.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model getModelByGuid(UUID guid) {
        return modelRepository.findById(guid).orElse(null);
    }

    @Override
    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model updateModel(UUID guid, Model updatedModel) {
        Optional<Model> existingModel = modelRepository.findById(guid);
        if (existingModel.isPresent()) {
            Model model = existingModel.get();
            model.setModel(updatedModel.getModel());
            return modelRepository.save(model);
        }
        return null;
    }

    @Override
    public void deleteModel(UUID guid) {
        modelRepository.deleteById(guid);
    }
}
