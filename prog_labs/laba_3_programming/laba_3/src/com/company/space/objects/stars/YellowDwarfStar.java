package com.company.space.objects.stars;

import com.company.space.events.ViewPlanet;
import com.company.space.objects.planets.SpaceObjectsNames;
import com.company.space.objects.SpaceObject;

import java.util.Objects;

public class YellowDwarfStar extends SpaceObject {

    private final Double producedLight;

    public YellowDwarfStar(SpaceObjectsNames planetName, Double illuminationLevel, Double producedLight) {
        super(planetName, illuminationLevel);
        this.producedLight = producedLight;
    }

    public void produceLight(SpaceObject planet, boolean beforeCave) {

        ViewPlanet viewPlanet = spaceObject -> beforeCave ? " with side lights " : " with forward lights ";

        System.out.println("Yellow Dwarf " + planetName + " produced light on " + planet.getPlanetName()
            + viewPlanet.getPlanetView(this));
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
