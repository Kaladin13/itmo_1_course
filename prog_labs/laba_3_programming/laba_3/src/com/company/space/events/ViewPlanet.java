package com.company.space.events;

import com.company.space.objects.SpaceObject;

@FunctionalInterface
public interface ViewPlanet {
    String getPlanetView(SpaceObject spaceObject);
}
