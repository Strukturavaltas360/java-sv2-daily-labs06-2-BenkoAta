package day04.hangman;

import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {
        new HangmanMain().run();
    }

    private String wordToFind;
    private String wordFound;
    private int chances = 8;

    HangmanMain () {
        wordToFind = "csütörtök";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordToFind.length(); i++) {
            sb.append('_');
        }
        wordFound = sb.toString();
    }

    private void run() {
        boolean win = false;

        do {
            String guess = askForGuess();
            if (wordToFind.contains(guess)) {
                System.out.println("Jó!");
                wordFound = updateWordFound(wordToFind, wordFound, guess);
                win = !wordFound.contains("_");
            }
            else {
                System.out.println("Rossz!");
                chances--;
            }
        } while (!win && chances > 0);

        if (win) {
            System.out.println("Ügyes, nyertél!");
        }
        else {
            System.out.println("Vesztettél");
        }
    }

    private String askForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Itt tartunk: %s", wordFound));
        System.out.println(String.format("Ennyit tippelhetsz még: %d", chances));
        System.out.print("Mi a következő tipped?: ");
        return scanner.nextLine();
    }

    private String updateWordFound(String wordToFind, String status, String guess) {
        char[] chars = status.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (wordToFind.charAt(i) == guess.charAt(0)) {
                chars[i] = guess.charAt(0);
            }
        }
        return new String(chars);
    }
}
