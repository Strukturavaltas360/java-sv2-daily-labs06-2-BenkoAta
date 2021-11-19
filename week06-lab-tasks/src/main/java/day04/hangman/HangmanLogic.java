package day04.hangman;

import java.util.Arrays;

public class HangmanLogic {
    private String wordToFind;
    private char[] wordFound;
    private int chances;

    public HangmanLogic(String wordToFind, int chances) {
        this.wordToFind = wordToFind;
        wordFound = new char[wordToFind.length()];
        Arrays.fill(wordFound, '_');
        this.chances = chances;
    }

    public boolean takeGuess(char guess) {
        if (wordToFind.indexOf(guess) >= 0) {
            updateWordFound(guess);
            return true;
        }
        chances--;
        return false;
    }

    private void updateWordFound(char guess) {
        for (int i = 0; i < wordToFind.length(); i++) {
            if (wordToFind.charAt(i) == guess) {
                wordFound[i] = guess;
            }
        }
    }

    public boolean finished() {
        return chances == 0 || won();
    }

    public boolean won() {
        return chances > 0 && getWordFound().indexOf('_') < 0;
    }

    public String getWordFound() {
        return String.valueOf(wordFound);
    }

    public int getChances() {
        return chances;
    }
}
