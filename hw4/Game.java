

public class Game {


    public static void main(String[] args){


        String name1 = "Shawn";
        String name2 = "Lin";
        String name3 = "Razzil";
        String name4 = "Blues";

        Fighter Shawn = new Fighter(name1, 126);
        Cleric Lin = new Cleric(name2, 1, 1, 2, 3, 3);
        Rogue Razzil = new Rogue(name3, 1, 2, 4, 1, 1);
        Wizard Blues = new Wizard(name4, 1, 1, 1, 4, 2);

        System.out.println(Shawn.toString());

    }
}


