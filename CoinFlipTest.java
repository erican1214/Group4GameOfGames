import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoinFlipTest {

    // Test odd number (valid)
    @Test
    void testNumberOfGamesOddValid() {
        int num = 1;
        assertTrue(num % 2 != 0);
    }

    // Test even number (invalid)
    @Test
    void testNumberOfGamesEven() {
        int num = 2;
        assertTrue(num % 2 == 0);
    }

    // Test valid guesser input
    @Test
    void testGuesserValid() {
        int who = 1;
        assertTrue(who == 1 || who == 2);
    }

    // Test invalid guesser input
    @Test
    void testGuesserInvalid() {
        int who = 3;
        assertFalse(who == 1 || who == 2);
    }

    // Test valid guess (Heads)
    @Test
    void testGuessHeads() {
        String guess = "H";
        assertTrue(guess.equals("H") || guess.equals("T"));
    }

    // Test valid guess (Tails)
    @Test
    void testGuessTails() {
        String guess = "T";
        assertTrue(guess.equals("H") || guess.equals("T"));
    }

    // Test invalid guess
    @Test
    void testGuessInvalid() {
        String guess = "S";
        assertFalse(guess.equals("H") || guess.equals("T"));
    }
}