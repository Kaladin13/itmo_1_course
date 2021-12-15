package com.company.planets;

import java.util.Objects;

public class YellowDwarfStar extends SpaceObject {

    private final Double producedLight;

    public YellowDwarfStar(PlanetNames planetName, Double illuminationLevel, Double producedLight) {
        super(planetName, illuminationLevel);
        this.producedLight = producedLight;
    }

    public void produceLight(SpaceObject planet) {
        System.out.println("Yellow Dwarf " + planetName + " produced light on " + planet.planetName);
        planet.setIlluminationLevel(producedLight);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        YellowDwarfStar that = (YellowDwarfStar) o;
        return Objects.equals(producedLight, that.producedLight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producedLight);
    }

    @Override
    public String toString() {
        return "YellowDwarfStar{" +
                "planetName=" + planetName +
                ", producedLight=" + producedLight +
                '}';
    }
}
