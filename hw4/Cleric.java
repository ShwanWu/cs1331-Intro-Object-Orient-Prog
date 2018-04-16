// This class should extend Character
// and implement all of its abstract methods.

public class Cleric extends Character {

    // constructor method based on name and seed.
    public Cleric(String name, int seed) {
        super(name, seed);
    }

    // constructor method based on features.
    public Cleric(String name, int level,
                   int strength, int dexterity,
                   int intelligence, int wisdom) {
        super(name, level, strength, dexterity, intelligence, wisdom);
    }


    @Override
    // attack method based on wisdom.
    public void attack(Character c) {
        if (!c.getIsDead()) {
            c.setHealth(c.getHealth() - getWisdom() * 6);
        } else {
            System.out.println("Cannot attack a dead character");
        }
        if (c.getHealth() <= 0) {
            c.setIsDead(true);
        }
    }

    // heal method based on wisdom.
    public void heal(Character c) {
        if (!c.getIsDead()) {
            c.setHealth(c.getHealth() + getWisdom() * 6);
            // health not beyond maximum(5 times its level).
            if (c.getHealth() > c.getLevel() * 5) {
                c.setHealth(c.getLevel() * 5);
            }
        } else {
            System.out.println("Cannot heal a dead character");
        }
    }

    @Override
    // increase the character’s level by 1,
    // reset the health to it’s maximum (5 times the level),
    // increase Wisdom by 2, and all other stats by 1.
    public void levelUp() {
        setLevel(getLevel() + 1);
        setHealth(getLevel() * 5);
        setStrength(getStrength() + 1);
        setDexterity(getDexterity() + 1);
        setWisdom(getWisdom() + 2);
        setIntelligence(getIntelligence() + 1);
    }

    @Override
    public String toString() {
        return "Level " + getLevel() + " cleric named "
                + getName() + " with " + getStrength()
                + " strength, " + getDexterity() + " dexterity, "
                + getIntelligence() + " intelligence, and "
                + getWisdom() + " wisdom.";
    }
}

