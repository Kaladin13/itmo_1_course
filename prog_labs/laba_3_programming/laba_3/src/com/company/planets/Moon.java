package com.company.planets;

import com.company.characters.CharacterActions;

public class Moon extends Planet{
    public Moon(Double reflectionRatio, PlanetNames planetName) {
        super(reflectionRatio, planetName);
    }

    public void activities(){
        System.out.println("При освящении = " + illuminationLevel + " доступны такие развлечения как " );
        for (Object current : CharacterActions.values()) {
            System.out.println(current);
        }
    }
}
