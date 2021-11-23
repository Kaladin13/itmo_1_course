package Moves;

import ru.ifmo.se.pokemon.*;

public class SteelWing extends PhysicalMove {

    private boolean isLowered;

    public SteelWing() {
        super(Type.STEEL, 70, 90);
        isLowered = false;
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (Math.random() <= 0.1) {
            isLowered = true;
            pokemon.setMod(Stat.DEFENSE, +1);
        }
    }

    @Override
    protected String describe() {
        if (isLowered) {
            isLowered = false;
            return "повышает защиту и наносит урон";
        }
        return "наносит урон";
    }
}
