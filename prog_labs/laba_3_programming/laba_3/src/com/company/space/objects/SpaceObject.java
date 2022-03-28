package com.company.space.objects;

import com.company.space.objects.planets.SpaceObjectsNames;

import java.util.Objects;

public abstract class SpaceObject {

    protected SpaceObjectsNames planetName;
    private Double illuminationLevel;

    public SpaceObject(SpaceObjectsNames planetName, Double illuminationLevel) {
        this.planetName = planetName;
        this.illuminationLevel = illuminationLevel;
    }

    public SpaceObjectsNames getPlanetName() {
        return planetName;
    }

    public Double getIlluminationLevel() {
        return illuminationLevel;
    }

    public void setIlluminationLevel(Double illuminationLevel) {
        this.illuminationLevel = illuminationLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        SpaceObject planet = (SpaceObject) obj;
        return planetName.equals(planet.planetName) && illuminationLevel.equals(planet.illuminationLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetName, illuminationLevel);
    }

    @Override
    public String toString() {
        return "SpaceObject{" +
                "planetName=" + planetName +
                ", illuminationLevel=" + illuminationLevel +
                '}';
    }
}
