package com.company.planets;

public class Earth extends Planet{

    public Earth(Double reflectionRatio, PlanetNames planetName) {
        super(reflectionRatio, planetName);
        System.out.println(PlanetNames.EARTH + " отражает в " + reflectionRatio + " больше раз света чем " + PlanetNames.MOON);
    }
}
