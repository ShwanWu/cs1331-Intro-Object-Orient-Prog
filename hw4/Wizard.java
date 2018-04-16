// This class should extend Character
// and implement all of its abstract methods.

public class Wizard extends Character {

    // constructor method based on name and seed.
    public Wizard(String name, int seed) {
        super(name, seed);
    }

    // constructor method based on features.
    public Wizard(String name, int level,
                   int strength, int dexterity,
                   int intelligence, int wisdom) {
        super(name, level, strength, dexterity, intelligence, wisdom);

    }

    @Override
    // attack method based on it's intelligence
    public void attack(Character c) {
        if (!c.getIsDead()) {
            c.setHealth(c.getHealth() - getIntelligence() * 4);
        } else {
            System.out.println("Cannot attack a dead character");
        }
        if (c.getHealth() <= 0) {
            c.setIsDead(true);
        }
    }

    // multiAttack method of Wizard.
    public void multiAttack(Character... c) {
        for (Character ci : c) {
            if (!ci.getIsDead()) {
                ci.setHealth(ci.getHealth() - getIntelligence() * 2);
            } else {
                System.out.println("Cannot damage a dead character");
            }
            if (ci.getHealth() <= 0) {
                ci.setIsDead(true);
            }
        }
    }

    @Override
    // increase the character’s level by 1,
    // reset the health to it’s maximum (5 times the level),
    // increase intelligence by 2, and all other stats by 1.
    public void levelUp() {
        setLevel(getLevel() + 1);
        setHealth(getLevel() * 5);
        setStrength(getStrength() + 1);
        setDexterity(getDexterity() + 1);
        setWisdom(getWisdom() + 1);
        setIntelligence(getIntelligence() + 2);
    }

    @Override
    public String toString() {
        return "Level " + getLevel() + " Wizard named "
                + getName() + " with " + getStrength()
                + " strength, " + getDexterity() + " dexterity, "
                + getIntelligence() + " intelligence, and "
                + getWisdom() + " wisdom.";
    }
}

