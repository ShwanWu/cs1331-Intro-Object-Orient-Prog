// This class should extend Character
// and implement all of its abstract methods.

public class Fighter extends Character {

    // constructor method based on name and seed.
    public Fighter(String name, int seed) {
        super(name, seed);
    }

    // constructor method based on features.
    public Fighter(String name, int level,
                   int strength, int dexterity,
                   int intelligence, int wisdom) {
        super(name, level, strength, dexterity, intelligence, wisdom);
    }


    @Override
    // attack method based on strength.
    public void attack(Character c) {
        if (!c.getIsDead()) {
            c.setHealth(c.getHealth() - (getStrength() + 10));
        } else {
            System.out.println("Cannot attack a dead character");
        }
        if (c.getHealth() <= 0) {
            c.setIsDead(true);
        }
    }

    @Override
    // increase the character’s level by 1,
    // reset the health to it’s maximum (5 times the level),
    // increase Strength by 2, and all other stats by 1.
    public void levelUp() {
        setLevel(getLevel() + 1);
        setHealth(getLevel() * 5);
        setStrength(getStrength() + 2);
        setDexterity(getDexterity() + 1);
        setWisdom(getWisdom() + 1);
        setIntelligence(getIntelligence() + 1);
    }

    @Override
    public String toString() {
        return "Level " + getLevel() + " fighter named "
                + getName() + " with " + getStrength()
                + " strength, " + getDexterity() + " dexterity, "
                + getIntelligence() + " intelligence, and "
                + getWisdom() + " wisdom.";
    }
}

