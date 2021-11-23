package com.company.planets;

import com.company.characters.Character;

import java.util.Objects;

public abstract class Planet implements LightReflection {
    protected Double illuminationLevel;
    protected Double reflectionRatio;
    protected PlanetNames planetName;

    public Planet(Double reflectionRatio, PlanetNames planetName) {
        this.reflectionRatio = reflectionRatio;
        this.planetName = planetName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Planet planet = (Planet) obj;
        return Objects.equals(planet.illuminationLevel, illuminationLevel)
                && Objects.equals(reflectionRatio,planet.reflectionRatio)
                && planetName.equals(planet.planetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(illuminationLevel,reflectionRatio,planetName);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "illuminationLevel=" + illuminationLevel +
                ", reflectionRatio=" + reflectionRatio +
                ", planetName=" + planetName +
                '}';
    }
}
