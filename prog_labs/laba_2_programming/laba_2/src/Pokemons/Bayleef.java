package Pokemons;

import Moves.PoisonJab;
import ru.ifmo.se.pokemon.Pokemon;

public class Bayleef extends Chikorita {
    public Bayleef(String name, int lvl) {
        super(name, lvl);
        setStats(60,62,80,63,80,60);
        addMove(new PoisonJab());
    }
}
