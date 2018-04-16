/**
 * Class create a simulation to test of all the methods.
 * @author ywu672
 * @version 1
 */
public class Driven {

    /**
     *main method for simulation of buying a item.
     * @param args in main method.
     */
    public static void main(String[] args) {

        String name = "wuyuli";
        int id = 903350030;
        int mealSwipes = 100;
        double diningDollars = 200.2;
        double buzzFunds = 330.3;

        // create a object of card.
        Buzzcard card = new Buzzcard(mealSwipes,
                diningDollars, buzzFunds);
        System.out.println(card.toString());

        // create a object of student
        Student student = new Student(card, name, id);
        System.out.println(student.toString());

        //student buy one or some item in stores.
        student.buyBrittainBuzzFunds(BrittainItem.BUFFET);
        System.out.println(student.toString());
    }
}
