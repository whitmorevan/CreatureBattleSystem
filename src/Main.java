import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        BattleSystem battleSystem = new BattleSystem();

        System.out.println("Choose your creature: ");
        System.out.println("1 - Orc");
        System.out.println("2 - Knight");
        System.out.println("3 - Gremlin");


        int choice = scn.nextInt();
        int enemyChoice = Rand.randomInt(1, 4);

        Creature a = battleSystem.createCreature(choice);
        Creature b = battleSystem.createCreature(enemyChoice);
        b.name = "Enemy " + b.getName();

        System.out.println("An " + b.getName() + " appeared! \n");


        // run the battle
        battleSystem.battle(a, b);
    }
}
