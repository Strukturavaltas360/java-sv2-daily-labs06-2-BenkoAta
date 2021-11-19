package day04.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanLogicTest {
    HangmanLogic hangmanLogic = new HangmanLogic("ablak", 2);

    @Test
    void takeGuessGoodGuessTest() {
        assertTrue(hangmanLogic.takeGuess('a'));
        assertEquals(2, hangmanLogic.getChances());
        assertEquals("a__a_", hangmanLogic.getWordFound());
    }

    @Test
    void takeGuessWrongGuessTest() {
        assertFalse(hangmanLogic.takeGuess('c'));
        assertEquals(1, hangmanLogic.getChances());
        assertEquals("_____", hangmanLogic.getWordFound());
    }

    @Test
    void finishedWonTest() {
        assertFalse(hangmanLogic.finished());
        hangmanLogic.takeGuess('a');
        hangmanLogic.takeGuess('b');
        assertFalse(hangmanLogic.finished());
        hangmanLogic.takeGuess('l');
        hangmanLogic.takeGuess('k');
        assertTrue(hangmanLogic.finished());
    }

    @Test
    void finishedLostTest() {
        assertFalse(hangmanLogic.finished());
        hangmanLogic.takeGuess('c');
        hangmanLogic.takeGuess('d');
        assertTrue(hangmanLogic.finished());
    }

    @Test
    void wonWonTest() {
        assertFalse(hangmanLogic.won());
        hangmanLogic.takeGuess('a');
        hangmanLogic.takeGuess('b');
        assertFalse(hangmanLogic.won());
        hangmanLogic.takeGuess('l');
        hangmanLogic.takeGuess('k');
        assertTrue(hangmanLogic.won());
    }

    @Test
    void wonLostTest() {
        assertFalse(hangmanLogic.won());
        hangmanLogic.takeGuess('c');
        hangmanLogic.takeGuess('d');
        assertFalse(hangmanLogic.won());
    }

    @Test
    void getWordFoundGoodGuessTest() {
        assertEquals("_____", hangmanLogic.getWordFound());
        hangmanLogic.takeGuess('a');
        assertEquals("a__a_", hangmanLogic.getWordFound());
    }

    @Test
    void getWordFoundWrongGuessTest() {
        assertEquals("_____", hangmanLogic.getWordFound());
        hangmanLogic.takeGuess('c');
        assertEquals("_____", hangmanLogic.getWordFound());
    }
}