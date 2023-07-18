package com.puantaj.project.controller;


import com.puantaj.project.models.Route;
import com.puantaj.project.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    RouteService routeService;

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
        Route createdRoute = routeService.createRoute(route);
        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
    }

    @GetMapping("/{guid}")
    public ResponseEntity<Route> getRouteById(@PathVariable("guid") UUID guid) {
        Route route = routeService.getRouteById(guid);
        if (route == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @PutMapping("/{guid}")
    public ResponseEntity<Route> updateRoute(@PathVariable("guid") UUID guid, @RequestBody Route route) {
        Route updatedRoute = routeService.updateRoute(guid, route);
        if (updatedRoute == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
    }

    @DeleteMapping("/{guid}")
    public ResponseEntity<Void> deleteRoute(@PathVariable("guid") UUID guid) {
        routeService.deleteRoute(guid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
