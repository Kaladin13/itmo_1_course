package Moves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {

    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.restore();
        Effect effect = new Effect().turns(2).condition(Status.SLEEP);
        pokemon.setCondition(effect);
        pokemon.setMod(Stat.HP, 6);
    }

    @Override
    protected String describe() {
        return "использовавший данную способность покемон отдыхает";
    }
}
