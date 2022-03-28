package com.company.characters;

import com.company.space.objects.planets.SpaceObjectsNames;
import com.company.space.objects.stars.CouldntCountException;

import java.util.Objects;

public class Character {
    public Character(String name) {
        this.name = name;
    }

    public void setCurrentAction(CharacterActions currentAction) {
        this.currentAction = currentAction;
        System.out.println(name +  " появился в истории и сейчас занят " + currentAction);
    }

    public void setOnPlanet(SpaceObjectsNames onPlanet) {
        this.onPlanet = onPlanet;
    }

    public void countStars() throws Throwable {
        throw  new CouldntCountException(new Exception("actual cause"));
    }

    public String getName() {
        return name;
    }

    private CharacterActions currentAction;
    private final String name;
    private SpaceObjectsNames onPlanet;

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
