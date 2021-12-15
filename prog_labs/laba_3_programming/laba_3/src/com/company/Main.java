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

        Planet moon = new Planet(PlanetNames.MOON, 1.0, 1.0);
        Planet earth = new Planet(PlanetNames.EARTH, 1.0, 90.0);
        System.out.println("Planet " + earth.getPlanetName() + " reflects light in "
                + earth.getReflectionRatio()/ moon.getReflectionRatio()
                + " more times than " + moon.getPlanetName());
        YellowDwarfStar sun = new YellowDwarfStar(PlanetNames.SUN, 100.0, 100.0);
        sun.produceLight(moon);
        moon.reflectLight(earth);
        System.out.println("При освящении = " + moon.getIlluminationLevel() + " доступны такие развлечения как " );
        for (Object current : CharacterActions.values()) {
            System.out.println(current);
        }
    }
}
