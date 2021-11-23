package Moves;

import ru.ifmo.se.pokemon.*;


public class PoisonJab extends PhysicalMove {

    private boolean isPoisoned;

    public PoisonJab() {
        super(Type.POISON, 80, 100);
        isPoisoned = false;
    }


    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.3) {
            isPoisoned = true;
            Effect.poison(pokemon);
        }
    }

    @Override
    protected String describe() {
        if (isPoisoned) {
            isPoisoned=false;
            return "наносит урон и отравляет";
        }
        return "наносит урон";
    }
}
