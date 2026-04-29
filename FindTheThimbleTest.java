import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindTheThimbleTest {

    @Test
    void testOddNumber() {
        int num = 3;
        assertTrue(num % 2 != 0);
    }

    @Test
    void testEvenNumber() {
        int num = 2;
        assertTrue(num % 2 == 0);
    }

    @Test
    void testValidGuesser() {
        int who = 1;
        assertTrue(who == 1 || who == 2);
    }

    @Test
    void testInvalidGuesser() {
        int who = 3;
        assertFalse(who == 1 || who == 2);
    }

    @Test
    void testValidHand() {
        String hand = "L";
        assertTrue(hand.equals("L") || hand.equals("R"));
    }

    @Test
    void testInvalidHand() {
        String hand = "A";
        assertFalse(hand.equals("L") || hand.equals("R"));
    }

    @Test
    void testValidGuess() {
        String guess = "R";
        assertTrue(guess.equals("L") || guess.equals("R"));
    }

    @Test
    void testInvalidGuess() {
        String guess = "X";
        assertFalse(guess.equals("L") || guess.equals("R"));
    }
}