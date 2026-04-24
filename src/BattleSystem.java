public class BattleSystem {
    public void battle(Creature a, Creature b) {
        int turn = 1;
        while (a.getHealth() > 0 && b.getHealth() > 0) {
            System.out.println("\n ~TURN " + turn + "~");


            float attackPower;

            // 25/75 chance of doing a heavy or normal attack
            if (Rand.randomInt(0, 4) == 0){
                attackPower = a.heavyAttack();
            }
            else{
                attackPower = a.attack();
            }
            a.readAction();

            b.defend(attackPower);
            b.readAction();

            b.heal();


            System.out.println(a);
            System.out.println(b);
            System.out.println();

            // swap turns
            Creature temp = a;
            a = b;
            b = temp;

            turn++;
            Input.waitForUserToPressEnter("Hit enter to continue! ");
        }

        if (a.getHealth() < b.getHealth()){
            System.out.println("\n" + a.getName() + " died!");
        }
        else{
            System.out.println("\n" + b.getName() + " died!");
        }
    }

    public Creature createCreature(int choice){
        Creature creature;
        if (choice == 1) {
            creature = new Orc(100, "Orc");
        }
        else if (choice == 2) {
            creature = new Knight(100, "Knight");
        }
        else if (choice == 3) {
            creature = new Gremlin(100, "Gremlin");
        }
        else {
            creature = new Creature(100, "Creature");
        }
        return creature;
    }


}
