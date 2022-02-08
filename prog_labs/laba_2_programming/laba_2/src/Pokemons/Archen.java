package Pokemons;

import Moves.Facade;
import Moves.Rest;
import Moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Archen extends Pokemon {
    public Archen(String name, int lvl) {
        super(name, lvl);
        setStats(55,112,45,74,45,70);
        setType(Type.ROCK,Type.FLYING);
        setMove(new Rest(),new Facade(),new Swagger());
    }
}
