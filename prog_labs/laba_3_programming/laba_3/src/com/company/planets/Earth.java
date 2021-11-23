package com.company.planets;

public class Earth extends Planet{

    @Override
    public void reflectLight(Planet planet) {
        planet.illuminationLevel = reflectionRatio * illuminationLevel;
    }

    public Earth(Double reflectionRatio, PlanetNames planetName) {
        super(reflectionRatio, planetName);
    }
}
