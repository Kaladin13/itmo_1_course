package com.company.planets;

import java.util.Objects;

public class Sun extends Planet {
    public Sun(Double reflectionRatio, PlanetNames planetName, Double producedLight) {
        super(reflectionRatio, planetName);
        this.illuminationLevel = 99999.0;
        this.producedLight = producedLight;
    }

    @Override
    public void reflectLight(Planet planet) {
    }

    public void produceLight(Planet planet){
        System.out.println(planetName + " отбрасывает свет на " + planet.planetName);
        planet.illuminationLevel = producedLight;
    }

    private final Double producedLight;

    @Override
    public boolean equals(Object obj) {
        Sun sun = (Sun)obj;
        return super.equals(obj) && sun.producedLight.equals(producedLight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producedLight,reflectionRatio,planetName,illuminationLevel);
    }

    @Override
    public String toString() {
        return "Sun{" +
                "illuminationLevel=" + illuminationLevel +
                ", reflectionRatio=" + reflectionRatio +
                ", planetName=" + planetName +
                ", producedLight=" + producedLight +
                '}';
    }
}
