import Pokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.addAlly(new Archen("Kvothe",20));
        battle.addAlly(new Mewtwo("Kaladin",25));
        battle.addAlly(new Bayleef("Vin",20));

        battle.addFoe(new Archeops("Shrike",20));
        battle.addFoe(new Chikorita("Ged",20));
        battle.addFoe(new Meganium("Fitz",20));

        battle.go();

    }
}
