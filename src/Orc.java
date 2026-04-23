public class Orc extends Creature{
    // Orcs have much higher chances of missing, but much higher attack dmg
    // 0 chance of defending

    // higher chance of missing, higher damage with successful hit
    @Override
    public float attack(){
        // 40% chance of missing
        if (Rand.randomInt(0, 10) < 4) {
            super.setAction(super.getName() + " missed!");
            return 0;
        }

        // otherwise, do damage between 10-40
        float power = Rand.randomFloat(10, 40);
        super.setAction(super.getName() + " attacked with power " + power + "!");
        return power;
    }

    @Override
    public float heavyAttack(){
        // 60% chance of missing
        if (Rand.randomInt(0, 10) < 6) {
            super.setAction(super.getName() + " missed!");
            return 0;
        }
        // otherwise, do damage between 15-50
        float power = Rand.randomFloat(15, 50);
        super.setAction(super.getName() + " attacked wildly with power " + power + "!");
        return power;
    }




    // does not defend
    @Override
    public void defend(float incomingPower){
        super.setAction(super.getName() + " is a proper orc and does not believe in defending");
        super.takeDamage(incomingPower);
    }



    public Orc(float health, String name){
        super(health, name);
    }



}
