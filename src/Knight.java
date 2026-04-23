public class Knight extends Creature{
    // knights have higher chance of missing, but higher chance of defending
    // regular attack dmg

    public float attack() {

        // 30% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            super.setAction(super.getName() + " missed!");
            return 0;
        }

        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(10, 20);
        super.setAction(super.getName() + " stabbed with power " + power + "!");
        return power;
    }

    @Override
    public float heavyAttack(){
        // 40% chance of missing
        if (Rand.randomInt(0, 10) < 4) {
            super.setAction(super.getName() + " missed!");
            return 0;
        }
        // otherwise, do damage between 10-30
        float power = Rand.randomFloat(10, 30);
        super.setAction(super.getName() + " attacked fiercely with power " + power + "!");
        return power;
    }



    // higher chance of blocking damage
    @Override
    public void defend(float incomingPower) {

        // 40 % chance of reducing damage taken
        if (Rand.randomInt(0, 40) < 1) {
            incomingPower = incomingPower * 0.8f;
            super.setAction(super.getName() + " used their shield and reduced damage taken to " + incomingPower);
        }
        else
        {
            super.setAction(super.getName() + " did not defend.");
        }

        super.takeDamage(incomingPower);
    }

    @Override
    public void heal(){
        // 20% chance to heal
        if (Rand.randomInt(0, 10) < 2){
            float healPower = Rand.randomFloat(0, 20);
            super.setAction(super.getName() + " heals themself for " + healPower + " health!");
            health += healPower;
        }
    }


    public Knight(float health, String name){
        super(health, name);
    }

}
