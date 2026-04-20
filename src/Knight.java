public class Knight extends Creature{

    // higher chance of missing
    public float attack() {

        // 30% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            return 0;
        }

        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(10, 20);
        action = name + " stabbed with power " + power + "!";
        return power;
    }


    // higher chance of blocking damage
    @Override
    public void defend(float incomingPower) {

        // 40 % chance of reducing damage taken
        if (Rand.randomInt(0, 40) < 1) {
            incomingPower = incomingPower * 0.8f;
            action = name + " used their shield and reduced damage taken to " + incomingPower;
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }

}
