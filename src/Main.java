public class Main {
    public static void main(String[] args) {

        // set up the creatures
        Creature a = new Orc();
        Creature b = new Knight();
        a.name = "Orc";
        a.health = 100;
        b.name = "Knight";
        b.health = 100;

        // set up the battle
        BattleSystem battleSystem = new BattleSystem();

        // run the battle
        battleSystem.battle(a, b);
    }
}
