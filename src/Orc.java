public class Orc extends Creature{


    // higher chance of missing, higher damage with successful hit
    @Override
    public float attack(){
        // 50% chance of missing
        if (Rand.randomInt(0, 10) < 5) {
            action = name + " missed!";
            return 0;
        }

        // otherwise, do damage between 10-40
        float power = Rand.randomFloat(10, 40);
        action = name + " attacked with power " + power + "!";
        return power;
    }

    // does not defend
    @Override
    public void defend(float incomingPower){
        action = name + " is a proper orc and does not believe in defending";
        health -= incomingPower;
    }




}
