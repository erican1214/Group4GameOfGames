import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GuessTheNumberFinalTest {

    @Test
    void testValidRange() {
        assertTrue(GuessTheNumber.isValidRange(10));
        assertFalse(GuessTheNumber.isValidRange(0));
        assertFalse(GuessTheNumber.isValidRange(-5));
    }

    @Test
    void testValidGuessCount() {
        assertTrue(GuessTheNumber.isValidGuessCount(3, 10)); // max = 5
        assertFalse(GuessTheNumber.isValidGuessCount(6, 10));
        assertFalse(GuessTheNumber.isValidGuessCount(-1, 10));
    }

    @Test
    void testCheckGuessCorrect() {
        assertEquals(0, GuessTheNumber.checkGuess(5, 5));
    }

    @Test
    void testCheckGuessHigher() {
        assertEquals(-1, GuessTheNumber.checkGuess(3, 5));
    }

    @Test
    void testCheckGuessLower() {
        assertEquals(1, GuessTheNumber.checkGuess(7, 5));
    }
}