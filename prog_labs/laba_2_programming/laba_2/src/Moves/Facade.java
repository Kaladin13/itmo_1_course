package Moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {

    private boolean isCritical;

    public Facade() {
        super(Type.NORMAL, 70, 100);
        isCritical = false;
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        if (pokemon.getCondition() == Status.BURN
                | pokemon.getCondition() == Status.POISON
                | pokemon.getCondition() == Status.PARALYZE) {
            isCritical = true;
            return 2.0;
        } else return super.calcCriticalHit(pokemon, pokemon1);
    }

    @Override
    protected String describe() {
        if (isCritical) {
            isCritical = false;
            return "наносит двойной урон";
        }
        return "наносит урон";
    }
}
