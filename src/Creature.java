public class Creature {
    public float health = 100;
    public String name;
    public String action;


    // Returns the damage done by the Creature
    public float attack() {

        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            return 0;
        }

        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(10, 20);
        action = name + " attacked with power " + power + "!";
        return power;
    }

    public float heavyAttack(){
        // 30% chance of missing
        if (Rand.randomInt(0, 10) < 3) {
            action = name + " missed!";
            return 0;
        }
        // otherwise, do damage between 10-30
        float power = Rand.randomFloat(10, 30);
        action = name + " strongly attacked with power " + power + "!";
        return power;
    }

    public void defend(float incomingPower) {

        // 10 % chance of reducing damage taken
        if (Rand.randomInt(0, 10) < 1) {
            incomingPower = incomingPower * 0.8f;
            action = name + " defended and reduced damage taken to " + incomingPower;
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }

    public void heal(){
        // 10% chance to heal
        if (Rand.randomInt(0, 10) < 1){
            float healPower = Rand.randomFloat(0, 20);
            System.out.println(name + " heals themself for " + healPower + " health!");
            health += healPower;
        }
    }


    public String readAction() {
        return action;
    }

    @Override
    public String toString() {
        return getClass() + "{name: " + name + ", health: " + health + "}";
    }
}
