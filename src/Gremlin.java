public class Gremlin extends Creature{

    @Override
    public float attack() {

        int numHits = Rand.randomInt(1, 10);
        int currHit = 0;
        int misses = 0;
        float power = 0;

        while (currHit < numHits){
            // 10% chance of missing
            if (Rand.randomInt(0, 10) < 1) {
                misses++;
            }

            // each hit, do damage between 2-5
            power += Rand.randomFloat(2, 5);
            currHit++;
        }

        action = name + " attacked " + numHits + " times, missed " + misses + " times, with a total power of " + power;
        return power;
    }

    @Override
    public void defend(float incomingPower){

        // 10% 0 dmg, 30% half dmg, 40% reduced damage, 20% no dodge
        int dodgeSuccess = Rand.randomInt(0, 10);

        switch(dodgeSuccess) {
            case 10:
                incomingPower = 0;
                action = name + " dodged completely out of the way!";
            case 7, 8, 9:
                incomingPower = incomingPower * 0.5f;
                action = name + " partially dodged and halved damage to " + incomingPower;
            case 3, 4, 5, 6:
                incomingPower = incomingPower * 0.8f;
                action = name + " partially dodged and reduced damage to " + incomingPower;
            case 1, 2:
                action = name + " couldn't dodge!";
        }


        health -= incomingPower;
    }
}


