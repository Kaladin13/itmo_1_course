package Pokemons;

import Moves.Bulldoze;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Archeops extends Archen {
    public Archeops(String name, int lvl) {
        super(name, lvl);
        setStats(75,140,65,112,65,110);
        addMove(new Bulldoze());
    }
}
