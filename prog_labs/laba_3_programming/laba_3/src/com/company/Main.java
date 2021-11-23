package com.company;

import com.company.characters.Character;
import com.company.characters.CharacterActions;
import com.company.planets.*;

public class Main {


    public static void main(String[] args) {

        Character[] backTravellers = new Character[4];
        backTravellers[0] = new Character("Znaika");
        backTravellers[1] = new Character("Fucksi");
        backTravellers[2] = new Character("Seledochka");
        backTravellers[3] = new Character("Dr. Zvezdochkin");
        for (Character person: backTravellers){
            person.setCurrentAction(CharacterActions.TRAVEL);
            person.setOnPlanet(PlanetNames.MOON);
        }

        Sun sun = new Sun(0.0,PlanetNames.SUN,1000.0);
        Earth earth = new Earth(90.0, PlanetNames.EARTH);
        Moon moon = new Moon(1.0, PlanetNames.MOON);

        sun.produceLight(earth);
        earth.reflectLight(moon);
        moon.activities();
    }
}
