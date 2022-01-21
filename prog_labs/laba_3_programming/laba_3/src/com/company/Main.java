package com.company;

import com.company.characters.Character;
import com.company.characters.CharacterActions;
import com.company.space.events.GlowingColours;
import com.company.space.events.ViewPlanet;
import com.company.space.objects.SpaceObject;
import com.company.space.objects.planets.Planet;
import com.company.space.objects.planets.SpaceObjectsNames;
import com.company.space.objects.stars.CouldntCountException;
import com.company.space.objects.stars.GlowingStar;
import com.company.space.objects.stars.YellowDwarfStar;

public class Main {


    public static void main(String[] args) {

        Character[] backTravellers = new Character[4];
        backTravellers[0] = new Character("Znaika");
        backTravellers[1] = new Character("Fucksi");
        backTravellers[2] = new Character("Seledochka");
        backTravellers[3] = new Character("Dr. Zvezdochkin");
        for (Character person: backTravellers){
            person.setCurrentAction(CharacterActions.TRAVEL);
            person.setOnPlanet(SpaceObjectsNames.MOON);
        }

        Planet moon = new Planet(SpaceObjectsNames.MOON, 1.0, 1.0);
        Planet earth = new Planet(SpaceObjectsNames.EARTH, 1.0, 90.0);
        System.out.println("Planet " + earth.getPlanetName() + " reflects light in "
                + earth.getReflectionRatio()/ moon.getReflectionRatio()
                + " more times than " + moon.getPlanetName());
        YellowDwarfStar sun = new YellowDwarfStar(SpaceObjectsNames.SUN, 100.0, 100.0);
        sun.produceLight(moon, false);
        moon.reflectLight(earth);
        System.out.println("При освящении = " + moon.getIlluminationLevel() + " доступны такие развлечения как " );
        for (Object current : CharacterActions.values()) {
            System.out.println(current);
        }

        class SpaceViewer implements ViewPlanet {

            public void viewSky(SpaceObject spaceObject, Character character) {
                System.out.println(character.getName() + " is seeing " + this.getPlanetView(spaceObject));
            }

            @Override
            public String getPlanetView(SpaceObject spaceObject) {
                return spaceObject.getPlanetName() + " not like harp, but like circle";
            }

        }


        try {
            backTravellers[0].countStars();
        }
        catch (CouldntCountException e) {
            System.out.println(e.getMessage());
        }

        GlowingStar glowingStars = new GlowingStar(SpaceObjectsNames.COUNTLESS_STARS, 1.0);
        glowingStars.sparkle(GlowingColours.WHITE);

        SpaceViewer spaceViewer = new SpaceViewer();
        spaceViewer.viewSky(earth, backTravellers[0]);

        sun.produceLight(earth, true);

    }
}
