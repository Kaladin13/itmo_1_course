package com.company;

import com.company.characters.Character;
import com.company.characters.CharacterActions;
import com.company.planets.*;

public class Main {

    public static void viewPlanet(Planet planet){
        System.out.println(planet);
    }

    public static void main(String[] args) {
        Earth earth = new Earth(90.0, PlanetNames.EARTH);
        Sun sun = new Sun(0.0,PlanetNames.SUN,1000.0);
        Moon moon = new Moon(1.0, PlanetNames.MOON);
        sun.produceLight(earth);
        earth.reflectLight(moon);
        System.out.println("Here is a list of planets:");
        viewPlanet(earth);
        viewPlanet(moon);
        viewPlanet(sun);
        Character[] backTravellers = new Character[4];
        System.out.println("Here is a list of characters:");
        backTravellers[0] = new Character("Znaika");
        backTravellers[1] = new Character("Fucksi");
        backTravellers[2] = new Character("Seledochka");
        backTravellers[3] = new Character("Dr. Zvezdochkin");
        for (Character person: backTravellers){
            person.setCurrentAction(CharacterActions.TRAVEL);
            person.setOnPlanet(PlanetNames.MOON);
            System.out.println(person);
        }
    }
}
