package com.puantaj.project.controller;

import com.puantaj.project.models.Model;
import com.puantaj.project.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    ModelService modelService;


    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{guid}")
    public ResponseEntity<Model> getModelByGuid(@PathVariable UUID guid) {
        Model model = modelService.getModelByGuid(guid);
        if (model != null) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Model> createModel(@RequestBody Model model) {
        Model createModel = modelService.createModel(model);
        return new ResponseEntity<>(createModel, HttpStatus.CREATED);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<Model> updateModel(@PathVariable UUID guid, @RequestBody Model updatedModel) {
        Model model = modelService.updateModel(guid, updatedModel);
        if (model != null) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteModel(@PathVariable UUID guid) {
        modelService.deleteModel(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
