// This class should extend Character
// and implement all of its abstract methods.

public class Rogue extends Character {

    // constructor method based on name and seed.
    public Rogue(String name, int seed) {
        super(name, seed);
    }

    // constructor method based on features.
    public Rogue(String name, int level,
                   int strength, int dexterity,
                   int intelligence, int wisdom) {
        super(name, level, strength, dexterity, intelligence, wisdom);

    }


    @Override
    // attack method based on dexterity.
    public void attack(Character c) {
        if (!c.getIsDead()) {
            c.setHealth(c.getHealth() - getDexterity() * 6);
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
    // increase dexterity by 3, and all other stats by 2.
    public void levelUp() {
        setLevel(getLevel() + 1);
        setHealth(getLevel() * 5);
        setStrength(getStrength() + 2);
        setDexterity(getDexterity() + 3);
        setWisdom(getWisdom() + 2);
        setIntelligence(getIntelligence() + 2);
    }

    @Override
    public String toString() {
        return "Level " + getLevel() + " rogue named "
                + getName() + " with " + getStrength()
                + " strength, " + getDexterity() + " dexterity, "
                + getIntelligence() + " intelligence, and "
                + getWisdom() + " wisdom.";
    }
}

