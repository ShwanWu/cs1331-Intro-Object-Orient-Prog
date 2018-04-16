/**
 * Class representing a Student with name,id and card.
 * @author ywu672
 * @version 1
 */
public class Student {

    private String name;
    private int id;
    private Buzzcard card;

    /**
     * Getter method for name of the student .
     * @return student's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for id of the student .
     * @return student's id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Constructor method for a student.
     * @param card information of the student.
     * @param name of the student.
     * @param id of a student.
     */
    public Student(Buzzcard card, String name, int id) {
        this.card = card;
        this.name = name;
        this.id = id;
    }

    /**
     * toString method for a Buzzcard.
     * @return information of the student with card.
     */
    public String toString() {
        return "Student named " + name + " with ID: "
                + id + " " + card.toString();
    }

    /**
     * method for buying a item in Brittain using MealSwipes.
     *@param item in Brittain.
     */
    public void buyBrittainMealSwipes(BrittainItem item) {
        if (card.getMealSwipes() > item.getMealSwipes()) {
            card.setMealSwipes(card.getMealSwipes()
                    - item.getMealSwipes());
        } else {
            System.out.println("You do not have "
                    + "the amount to buy this item :(");
        }
    }

    /**
     * method for buying a item in Brittain using BuzzFunds.
     *@param item in Brittain.
     */
    public void buyBrittainBuzzFunds(BrittainItem item) {
        if (card.getbuzzFunds() > item.getBuzzFunds()) {
            card.setBuzzFunds(card.getbuzzFunds()
                    - item.getBuzzFunds());
        } else {
            System.out.println("You do not have "
                    + "the amount to buy this item :(");
        }
    }

    /**
     * method for buying a item in Burdells using BuzzFunds.
     *@param item in Burdells.
     */
    public void buyBurdellsBuzzFunds(BurdellsItem item) {
        if (card.getbuzzFunds() > item.getBuzzFunds()) {
            card.setBuzzFunds(card.getbuzzFunds()
                    - item.getBuzzFunds());
        } else {
            System.out.println("You do not have "
                    + "the amount to buy this item :(");
        }
    }

    /**
     * method for buying a item in Subway using DiningDollars.
     *@param item in subway.
     */
    public void buySubwayDiningDollars(SubwayItem item) {
        if (card.getDiningDollars() > item.getDiningDollars()) {
            card.setDiningDollars(card.getDiningDollars()
                    - item.getDiningDollars());
        } else {
            System.out.println("You do not have "
                    + "the amount to buy this item :(");
        }
    }

    /**
     * method for buying a item in Subway using BuzzFunds.
     *@param item in subway.
     */
    public void buySubwayBuzzFunds(SubwayItem item) {
        if (card.getbuzzFunds() > item.getBuzzFunds()) {
            card.setBuzzFunds(card.getbuzzFunds()
                    - item.getBuzzFunds());
        } else {
            System.out.println("You do not have "
                    + "the amount to buy this item :(");
        }
    }
}

