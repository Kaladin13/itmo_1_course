package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class SignalBeam extends SpecialMove {

    private boolean isConfused ;

    public SignalBeam() {
        super(Type.BUG, 75, 100);
        isConfused = false;
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < 0.1) {
            isConfused = true;
            pokemon.confuse();
        }
    }

    @Override
    protected String describe() {
        if (isConfused) {
            isConfused = false;
            return "атакует и вводит врага в замешательство";
        }
        return "атакует";
    }
}
