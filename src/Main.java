public class Main {
    public static void main(String[] args) {


        BattleSystem battleSystem = new BattleSystem();

        System.out.println("~~~CREATURES~~~");
        System.out.println("1 - Orc");
        System.out.println("2 - Knight");
        System.out.println("3 - Gremlin");
        System.out.println("Other - Basic Creature");


        int choice = Input.getUserInt("\nChoose your fighter: ");
        int enemyChoice = Rand.randomInt(1, 4);

        Creature a = battleSystem.createCreature(choice);
        Creature b = battleSystem.createCreature(enemyChoice);
        b.setAsEnemy();

        System.out.println("\nAn " + b.getName() + " appeared!");


        // run the battle
        battleSystem.battle(a, b);
    }
}
