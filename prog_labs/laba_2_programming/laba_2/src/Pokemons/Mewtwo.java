package Pokemons;


import Moves.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Mewtwo extends Pokemon {
    public Mewtwo(String name, int lvl) {
        super(name, lvl);
        setStats(106,110,90,154,90,130);
        setType(Type.PSYCHIC);
        setMove(new PoisonJab(),new Rest(),new Slash(), new SteelWing());
    }


}
