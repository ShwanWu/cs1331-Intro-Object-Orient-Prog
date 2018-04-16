import java.util.Random;
import java.util.Scanner;

public class WordGuess {

    static final String[] CANDIDATES = {"cat", "dad", "dog", "mom", "rat"};

    public static void main(String[] args) {

        String secretWord = args.length > 0
                ? CANDIDATES[Integer.parseInt(args[0])]
                : CANDIDATES[new Random().nextInt(CANDIDATES.length)];

        char[] currentWord;
        char[] word;
        String wrongWord = "";
        int left = 5;

        word = secretWord.toCharArray();
        currentWord = new char[word.length];
        for (int i = 0; i < word.length; i++) {
            currentWord[i] = '_';
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Missed letters (5 left): ");
        System.out.println("Current guess: ___");
        System.out.print("Guess a letter: ");

        while (left > 0) {
            String in = scan.next();
            char c = in.charAt(0);
            if (secretWord.indexOf(c) != -1
                    && String.valueOf(currentWord).contains("_")) {
                for (int i = 0; i < word.length; i++) {
                    if (c == word[i]) {
                        currentWord[i] = c;
                    }
                }
                if (String.valueOf(currentWord).contains("_")) {
                    System.out.println("\nMissed letters ("
                            + left + " left): " + wrongWord);
                    System.out.println("Current guess: "
                            + String.valueOf(currentWord));
                    System.out.print("Guess a letter: ");
                } else {
                    System.out.println("\nMissed letters: " + wrongWord);
                    System.out.println("Final guess: " + secretWord);
                    System.out.print("Congratulations! You got it!");
                    left = 0;
                }
            }
            if (secretWord.indexOf(c) == -1) {
                left--;
                wrongWord += String.valueOf(c);
                if (left == 0) {
                    System.out.println("\nMissed letters: " + wrongWord);
                    System.out.println("Final guess: "
                            + String.valueOf(currentWord));
                    System.out.println("Sorry, too many misses. "
                            + "The secret word was " + secretWord);
                } else {
                    System.out.println("\nMissed letters ("
                            + left + " left): " + wrongWord);
                    System.out.println("Current guess: "
                            + String.valueOf(currentWord));
                    System.out.print("Guess a letter: ");
                }
            }
        }
    }
}
