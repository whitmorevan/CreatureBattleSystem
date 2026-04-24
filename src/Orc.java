public class Orc extends Creature{
    // Orcs have much higher chances of missing, but much higher attack dmg
    // 0 chance of defending

    public Orc(float health, String name){
        super(health, name);
    }


    // higher chance of missing, higher damage with successful hit
    @Override
    public float attack(){
        // 40% chance of missing
        if (Rand.randomInt(0, 10) < 4) {
            queueAction(getName() + " missed!");
            return 0;
        }

        // otherwise, do damage between 10-40
        float power = Rand.randomFloat(10, 40);
        queueAction(getName() + " attacked with power " + power + "!");
        return power;
    }

    @Override
    public float heavyAttack(){
        // 60% chance of missing
        if (Rand.randomInt(0, 10) < 6) {
            queueAction(getName() + " missed!");
            return 0;
        }
        // otherwise, do damage between 15-50
        float power = Rand.randomFloat(15, 50);
        queueAction(getName() + " attacked wildly with power " + power + "!");
        return power;
    }


    // does not defend
    @Override
    public void defend(float incomingPower){
        queueAction(getName() + " is a proper orc and does not believe in defending.");
        takeDamage(incomingPower);
    }


}
