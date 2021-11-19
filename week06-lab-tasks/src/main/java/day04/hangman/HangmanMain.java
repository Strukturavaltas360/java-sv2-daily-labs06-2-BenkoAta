package day04.hangman;

import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {
        new HangmanMain().run();
    }

    private void run() {
        HangmanLogic hangmanLogic = new HangmanLogic("csütörtök", 4);
        do {
            char guess;
            try {
                guess = askForGuess(hangmanLogic);
                if (hangmanLogic.takeGuess(guess)) {
                    System.out.println("Jó!");
                } else {
                    System.out.println("Rossz!");
                }
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        } while (!hangmanLogic.finished());
        System.out.println(hangmanLogic.won() ? "Ügyes, nyertél!" : "Vesztettél");
    }

    private char askForGuess(HangmanLogic hangmanLogic) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Itt tartunk: %s", hangmanLogic.getWordFound()));
        System.out.println(String.format("Ennyit tippelhetsz még: %d", hangmanLogic.getChances()));
        System.out.print("Mi a következő tipped?: ");
        String input = scanner.nextLine();
        if (input.length() == 1) {
            return input.charAt(0);
        } else {
            throw new IllegalStateException("Hibás tipp!");
        }
    }

}
