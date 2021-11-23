package com.company.characters;

import com.company.planets.PlanetNames;

import java.util.Objects;

public class Character {
    public Character(String name) {
        this.name = name;
    }

    public void setCurrentAction(CharacterActions currentAction) {
        this.currentAction = currentAction;
        System.out.println(name +  " появился в истории и сейчас занят " + currentAction);
    }

    public void setOnPlanet(PlanetNames onPlanet) {
        this.onPlanet = onPlanet;
    }

    private CharacterActions currentAction;
    private String name;
    private PlanetNames onPlanet;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return name.equals(character.name)
                && currentAction.equals(character.currentAction)
                && onPlanet.equals(character.onPlanet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currentAction, onPlanet);
    }

    @Override
    public String toString() {
        return "Character{" +
                "currentAction=" + currentAction +
                ", name='" + name + '\'' +
                ", onPlanet=" + onPlanet +
                '}';
    }
}
