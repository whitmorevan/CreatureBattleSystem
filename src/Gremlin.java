public class Gremlin extends Creature{
    // Gremlins do many little attacks
    // and can dodge attacks fully


    @Override
    public float attack() {
        // can hit 1-10 times
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

        action = super.getName() + " attacked " + numHits + " times, missed " + misses + " times, with a total power of " + power;
        return power;
    }

    @Override
    public float heavyAttack(){
        // can hit 3-13 times
        int numHits = Rand.randomInt(3, 13);
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

        action = super.getName() + " attacked wildly " + numHits + " times, missed " + misses + " times, with a total power of " + power;
        return power;
    }

    @Override
    public void defend(float incomingPower){

        // 10% 0 dmg, 30% half dmg, 40% reduced damage, 20% no dodge
        int dodgeSuccess = Rand.randomInt(0, 10);

        switch(dodgeSuccess) {
            case 10:
                incomingPower = 0;
                action = super.getName() + " dodged completely out of the way!";
            case 7, 8, 9:
                incomingPower = incomingPower * 0.5f;
                action = super.getName() + " partially dodged and halved damage to " + incomingPower;
            case 3, 4, 5, 6:
                incomingPower = incomingPower * 0.8f;
                action = super.getName() + " partially dodged and reduced damage to " + incomingPower;
            case 1, 2:
                action = super.getName() + " couldn't dodge!";
        }

        super.takeDamage(incomingPower);
    }



    public Gremlin(float health, String name){
        super(health, name);
    }

}


