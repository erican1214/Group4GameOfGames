import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GuessTheNumberFinalTest {

    @Test
    void testValidRange() {
        assertTrue(GuessTheNumberLogic.isValidRange(10));
        assertFalse(GuessTheNumberLogic.isValidRange(0));
        assertFalse(GuessTheNumberLogic.isValidRange(-5));
    }

    @Test
    void testValidGuessCount() {
        assertTrue(GuessTheNumberLogic.isValidGuessCount(3, 10)); // max = 5
        assertFalse(GuessTheNumberLogic.isValidGuessCount(6, 10));
        assertFalse(GuessTheNumberLogic.isValidGuessCount(-1, 10));
    }

    @Test
    void testCheckGuessCorrect() {
        assertEquals(0, GuessTheNumberLogic.checkGuess(5, 5));
    }

    @Test
    void testCheckGuessHigher() {
        assertEquals(-1, GuessTheNumberLogic.checkGuess(3, 5));
    }

    @Test
    void testCheckGuessLower() {
        assertEquals(1, GuessTheNumberLogic.checkGuess(7, 5));
    }
}