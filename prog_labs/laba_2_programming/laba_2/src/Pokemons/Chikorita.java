package Pokemons;

import Moves.Facade;
import Moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Chikorita extends Pokemon {
    public Chikorita(String name, int lvl) {
        super(name, lvl);
        setType(Type.GRASS);
        setStats(45,49,65,49,65,45);
        setMove(new Facade(),new Swagger());
    }
}
