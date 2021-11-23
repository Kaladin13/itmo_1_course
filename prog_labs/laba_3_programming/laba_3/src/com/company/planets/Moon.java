package com.company.planets;

public class Moon extends Planet{
    public Moon(Double reflectionRatio, PlanetNames planetName) {
        super(reflectionRatio, planetName);
    }

    @Override
    public void reflectLight(Planet planet) {
        planet.illuminationLevel = reflectionRatio * illuminationLevel;
    }
}
