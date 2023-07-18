package com.puantaj.project.service;

import com.puantaj.project.models.Route;
import com.puantaj.project.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    RouteRepository routeRepository;

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route getRouteById(UUID guid) {
        return routeRepository.findById(guid).orElse(null);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route updateRoute(UUID guid, Route route) {
        Route existingRoute = routeRepository.findById(guid).orElse(null);
        if (existingRoute == null) {
            return null;
        }
        // Güncelleme işlemleri
        existingRoute.setCode(route.getCode());
        existingRoute.setName(route.getName());
        existingRoute.setPersonInCharge(route.getPersonInCharge());
        existingRoute.setMaxPriceWeekday(route.getMaxPriceWeekday());
        existingRoute.setMaxPriceWeekend(route.getMaxPriceWeekend());
        existingRoute.setModelYear(route.getModelYear());
        existingRoute.setNumberOfSeats(route.getNumberOfSeats());
        existingRoute.setOptimisticLockField(route.getOptimisticLockField());
        existingRoute.setGcrecord(route.getGcrecord());
        existingRoute.setHostess(route.isHostess());
        existingRoute.setPersonInCharge(route.getPersonInCharge());

        return routeRepository.save(existingRoute);
    }

    @Override
    public void deleteRoute(UUID guid) {
        routeRepository.deleteById(guid);
    }
}
