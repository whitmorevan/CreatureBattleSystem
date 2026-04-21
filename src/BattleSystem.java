import java.sql.SQLOutput;

public class BattleSystem {
    public void battle(Creature a, Creature b) {
        while (a.health > 0 && b.health > 0) {

            float attackPower;

            // 50/50 chance of doing a heavy or normal attack
            if (Rand.randomInt(0, 2) == 1){
                attackPower = a.attack();
            }
            else{
                attackPower = a.heavyAttack();
            }
            System.out.println(a.readAction());

            b.defend(attackPower);
            System.out.println(b.readAction());

            b.heal();


            System.out.println(a);
            System.out.println(b);
            System.out.println();

            // swap turns
            Creature temp = a;
            a = b;
            b = temp;
        }
    }

    public Creature createCreature(int choice){
        Creature creature;
        if (choice == 1) {
            creature = new Orc();
            creature.name = "Orc";
        }
        else if (choice == 2) {
            creature = new Knight();
            creature.name = "Knight";
        }
        else if (choice == 3) {
            creature = new Gremlin();
            creature.name = "Gremlin";
        }
        else {
            creature = new Creature();
            creature.name = "Creature";
        }
        return creature;
    }


}
