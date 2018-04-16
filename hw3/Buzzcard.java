/**
 * Class representing a Buzzcard with 3 amount left.
 * @author ywu672
 * @version 1
 */
public class Buzzcard {

    private int mealSwipes;
    private double diningDollars;
    private double buzzFunds;

    /**
     * Setter method for the meal swipes left in card.
     * @param mealSwipes left in card.
     */
    public void setMealSwipes(int mealSwipes) {
        this.mealSwipes = mealSwipes;
    }

    /**
     * Setter method for the diningDollars left in card.
     * @param diningDollars left in card.
     */
    public void setDiningDollars(double diningDollars) {
        this.diningDollars = diningDollars;
    }

    /**
     * Setter method for buzzFunds left in card.
     * @param buzzFunds left in card.
     */
    public void setBuzzFunds(double buzzFunds) {
        this.buzzFunds = buzzFunds;
    }

    /**
     * Getter method for the meal swipes left in card.
     * @return Meal swipe left.
     */
    public int getMealSwipes() {
        return this.mealSwipes;
    }

    /**
     * Getter method for the meal swipes left in card.
     * @return diningDollars left.
     */
    public double getDiningDollars() {
        return this.diningDollars;
    }

    /**
     * Getter method for the meal swipes left in card.
     * @return buzzFunds left.
     */
    public double getbuzzFunds() {
        return this.buzzFunds;
    }

    /**
     * Constructor method for a Buzzcard.
     * @param mealSwipes that left in card.
     * @param diningDollars that left in card.
     * @param buzzFunds that left in card.
     */
    public Buzzcard(int mealSwipes,
                    double diningDollars, double buzzFunds) {
        this.mealSwipes = mealSwipes;
        this.diningDollars = diningDollars;
        this.buzzFunds = buzzFunds;
    }

    /**
     * toString method for a Buzzcard.
     * @return information of a card with amount left.
     */
    public String toString() {
        return "Buzzcard balance with Dining Dollars:"
                + diningDollars + " BuzzFunds:"
                + buzzFunds + " Meal Swipes:" + mealSwipes;
    }


}



