import java.util.Random;
/**
 * Class representing a abstract character.
 * @author ywu672
 * @version 1
 */
public abstract class Character {

    private String name;
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int health;
    private boolean isDead = false;

    /**
     * Constructor method for a character with level 1.
     * @param name the name of the character.
     * @param seed used to generate the other stats randomly.
     */
    public Character(String name, int seed) {
        //implement this constructor using constructor delegation.
        Random r = new Random(seed);
        this.name = name;
        setLevel(1);
        setHealth(5);
        this.strength = r.nextInt(6) + 1;
        this.dexterity = r.nextInt(6) + 1;
        this.intelligence = r.nextInt(6) + 1;
        this.wisdom = r.nextInt(6) + 1;
    }

    /**
     * Constructor method for a Character with user-defined.
     * @param name the name of the character.
     * @param level the level of the character.
     * @param strength the strength of the character.
     * @param dexterity the dexterity of the character.
     * @param intelligence the name of the character.
     * @param wisdom the wisdom of the character.
     */
    public Character(String name, int level,
                     int strength, int dexterity,
                     int intelligence, int wisdom) {
        //implement this constructor
        this.name = name;
        this.level = level;
        this.health = getLevel() * 5;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
    }

    /**
     * Getter method for name of character .
     * @return name of character.
     */
    public String getName() {
        //implement this method
        return name;
    }

    /**
     * Getter method for level of character
     * @return level of character.
     */
    public int getLevel() {
        //implement this method
        return level;
    }

    /**
     * Setter method for level of character.
     * @param level level of character.
     */
    public void setLevel(int level) {
        //implement this method
        this.level = level;
    }

    /**
     * Getter method for strength of character.
     * @return strength of character
     */
    public int getStrength() {
        //implement this method
        return strength;
    }

    /**
     * Setter method for strength of character.
     * @param strength of character.
     */
    public void setStrength(int strength) {
        //implement this method
        this.strength = strength;
    }

    /**
     * Getter method for dexterity of character.
     * @return dexterity of character.
     */
    public int getDexterity() {
        //implement this method
        return dexterity;
    }

    /**
     * Setter method for dexterity of character.
     * @param dexterity of character.
     */
    public void setDexterity(int dexterity) {
        //implement this method
        this.dexterity = dexterity;
    }

    /**
     * Getter method for intelligence of character.
     * @return intelligence of character.
     */
    public int getIntelligence() {
        //implement this method
        return intelligence;
    }

    /**
     * Setter method for intelligence of character.
     * @param intelligence of character.
     */
    public void setIntelligence(int intelligence) {
        //implement this method
        this.intelligence = intelligence;
    }

    /**
     * Getter method for wisdom of character.
     * @return wisdom of character.
     */
    public int getWisdom() {
        //implement this method
        return wisdom;
    }

    /**
     * Setter method for wisdom of character.
     * @param wisdom of character.
     */
    public void setWisdom(int wisdom) {
        //implement this method
        this.wisdom = wisdom;
    }

    /**
     * Getter method for health of character.
     * @return health of character.
     */
    public int getHealth() {
        //implement this method
        return health;
    }

    /**
     * Setter method for health of character.
     * @param health of character.
     */
    public void setHealth(int health) {
        //implement this method
        this.health = health;
    }

    /**
     * Getter method for Dead or not of character.
     * @return Dead or alive of character.
     */
    public boolean getIsDead() {
        //implement this method
        return isDead;
    }

    /**
     * Setter method for Dead or alive of character.
     * @param isDead Dead or alive of character.
     */
    public void setIsDead(boolean isDead) {
        //implement this method
        this.isDead = isDead;
    }

    /**
     * levelUp method for character.
     */
    public abstract void levelUp();

    /**
     * attack method for character.
     * @param c the target character.
     */
    public abstract void attack(Character c);

    /**
     * toString method for character.
     */
    public abstract String toString();

}
