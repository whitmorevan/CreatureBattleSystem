public class Knight extends Creature{
    // knights have higher chance of missing, but higher chance of defending
    // regular attack dmg

    public Knight(float health, String name){
        super(health, name);
    }



    public float attack() {

        // 30% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            queueAction(getName() + " missed!");
            return 0;
        }

        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(10, 20);
        queueAction(getName() + " stabbed with power " + power + "!");
        return power;
    }

    @Override
    public float heavyAttack(){
        // 40% chance of missing
        if (Rand.randomInt(0, 10) < 4) {
            queueAction(getName() + " missed!");
            return 0;
        }
        // otherwise, do damage between 10-30
        float power = Rand.randomFloat(10, 30);
        queueAction(getName() + " attacked fiercely with power " + power + "!");
        return power;
    }



    // higher chance of blocking damage
    @Override
    public void defend(float incomingPower) {

        // 40 % chance of reducing damage taken
        if (Rand.randomInt(0, 40) < 1) {
            incomingPower = incomingPower * 0.8f;
            queueAction(getName() + " used their shield and reduced damage taken to " + incomingPower);
        }
        else
        {
            queueAction(getName() + " did not defend.");
        }

        takeDamage(incomingPower);
    }

}
