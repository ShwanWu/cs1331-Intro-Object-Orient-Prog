import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * @author ywu672
 */
public class Battleship {

    /**
     * @param n The row and column number of the array.
     * @return the initial created 2-D array board.
     */
    public static char[][] intiBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '~';
            }
        }
        return board;
    }

    /**
     * @param playerTurn represent the operation by which player.
     * @param board the board after been guessed by player.
     * @param hitsLeft how many ships remain un-guessed.
     */
    public static void printBoard(int playerTurn, char[][] board,
                                  int hitsLeft) {
        System.out.println("Player " + playerTurn + " ("
                + hitsLeft + " hits left):");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * @param board the board before been guessed by player.
     * @param target the input String guess of shipLocation by player.
     * @param shipLocations the right location of all the ships of the player.
     * @param hitsLeft how many ships remain un-guessed.
     * @return int how many ships remain un-guessed after this guess.
     */
    public static int fireMissile(char[][] board, String target,
                                  String[] shipLocations, int hitsLeft) {
        // target and returns if a ship is hit
        int[] indices = convertLocation(target);
        int row = indices[0];
        int col = indices[1];
        if (board[row][col] == '~') {
            if (isShip(target, shipLocations)) {
                board[row][col] = 'X';
                System.out.println("Hit!");
                hitsLeft--;
            } else {
                board[row][col] = 'O';
                System.out.println("Miss!");
            }
        } else {
            System.out.println(target + " has already been chosen!");
        }
        return hitsLeft;
    }

    /**
     * @param target the input String guess of shipLocation by player.
     * @param shipLocations the location of all the ships of the player.
     * @return boolean whether the target if ship or not.
     */
    public static boolean isShip(String target, String[] shipLocations) {
        for (int i = 0; i < shipLocations.length; i++) {
            if (shipLocations[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param coordinate the input target in the form of String.
     * @return int[] the target in the form of indices array.
     */
    public static int[] convertLocation(String coordinate) {
        //  with the coordinate string eg:f1 = {0,5}
        char[] cs1 = coordinate.toCharArray();
        int[] cs2 = new int[2];
        cs2[0] = (int) cs1[1] - 49;
        cs2[1] = (int) cs1[0] - 97;
        return cs2;
    }


    public static void main(String[] args) {
        int fileInd = (args.length > 0)
                ? Integer.parseInt(args[0])
                : new Random().nextInt(4);

        String filename = "game" + fileInd + ".txt";
        try {
            Scanner fileReader = new Scanner(new
                    File(filename));
            Scanner inputScanner = new Scanner(System.in);
            //  using the methods defined above
            String[] a = new String[3];
            int i;
            for (i = 0; i < 3; i++) {
                a[i] = fileReader.nextLine();
            }

            int n = Integer.parseInt(a[0]);
            String[] shipLocations1 = a[1].split(" ");
            String[] shipLocations2 = a[2].split(" ");
            char[][] board1 = intiBoard(n);
            char[][] board2 = intiBoard(n);
            int playerTurn = 1;
            boolean over = false;
            int hitsLeft1 = shipLocations1.length;
            int hitsLeft2 = shipLocations2.length;

            while (!over) {
                if (playerTurn == 1) {
                    printBoard(playerTurn, board1, hitsLeft1);
                    System.out.print("Enter missile location: ");
                    String target = inputScanner.nextLine();
                    hitsLeft1 = fireMissile(
                            board1, target, shipLocations1, hitsLeft1);
                    printBoard(playerTurn, board1, hitsLeft1);
                    playerTurn = 2;
                } else {
                    printBoard(playerTurn, board2, hitsLeft2);
                    System.out.print("Enter missile location: ");
                    String target = inputScanner.nextLine();
                    hitsLeft2 = fireMissile(
                            board2, target, shipLocations2, hitsLeft2);
                    printBoard(playerTurn, board2, hitsLeft2);
                    playerTurn = 1;
                }
                System.out.println("\n----------\n");
                if (hitsLeft1 == 0) {
                    System.out.print("The winner is Player 1");
                    over = true;
                } else if (hitsLeft2 == 0) {
                    System.out.print("The winner is Player 2");
                    over = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Make sure that " + filename
                    + " is in the current directory!");
        }
    }
}
