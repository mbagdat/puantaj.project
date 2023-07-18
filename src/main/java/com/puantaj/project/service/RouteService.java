package com.puantaj.project.service;

import com.puantaj.project.models.Route;

import java.util.List;
import java.util.UUID;

public interface RouteService {
    Route createRoute(Route route);
    Route getRouteById(UUID guid);
    List<Route> getAllRoutes();
    Route updateRoute(UUID guid, Route route);
    void deleteRoute(UUID guid);
}
