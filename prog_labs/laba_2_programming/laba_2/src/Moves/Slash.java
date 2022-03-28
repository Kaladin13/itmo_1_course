package Moves;

import ru.ifmo.se.pokemon.*;

public class Slash extends PhysicalMove {

    public Slash() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        //We don't have ability to implement this side effect
        return super.calcCriticalHit(pokemon, pokemon1);
    }

    @Override
    protected String describe() {
        return "наносит урон";
    }
}
