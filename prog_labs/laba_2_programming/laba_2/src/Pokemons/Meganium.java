package Pokemons;

import Moves.SignalBeam;

public class Meganium extends Bayleef{
    public Meganium(String name, int lvl) {
        super(name, lvl);
        setStats(80,82,100,83,100,80);
        addMove(new SignalBeam());
    }
}
