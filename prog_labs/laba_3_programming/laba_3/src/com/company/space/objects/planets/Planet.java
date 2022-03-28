package com.company.space.objects.planets;


import com.company.space.events.LightReflection;
import com.company.space.objects.SpaceObject;

public class Planet extends SpaceObject implements LightReflection {

    private Double reflectionRatio;

    public Planet(SpaceObjectsNames planetName, Double illuminationLevel, Double reflectionRatio) {
        super(planetName, illuminationLevel);
        this.reflectionRatio = reflectionRatio;
    }


    public Double getReflectionRatio() {
        return reflectionRatio;
    }

    public void setReflectionRatio(Double reflectionRatio) {
        this.reflectionRatio = reflectionRatio;
    }

    @Override
    public void reflectLight(SpaceObject planet) {
        System.out.println("Planet " + this.planetName + " reflects light on " + planet.getPlanetName());
        planet.setIlluminationLevel(this.getIlluminationLevel() * this.reflectionRatio);
    }
}
