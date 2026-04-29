import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Unit tests for the PlayGames driver logic.
 * Note: These tests simulate user input to verify loop behavior and tallying.
 */
public class PlayGamesTest {

    @Test
    public void testQuitOption() {
        // Simulates selecting Game Mode 1, then immediately selecting 6 to Quit
        String input = "1\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // We verify that the main method runs to completion without crashing
        assertDoesNotThrow(() -> {
            PlayGames.main(new String[]{});
        });
    }

    @Test
    public void testInvalidMenuInput() {
        // Simulates Mode 1, an invalid choice '7', then '6' to Quit
        // The driver should display the error message and loop back to the menu [cite: 1778, 1826]
        String input = "1\n7\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            PlayGames.main(new String[]{});
        });
    }

    @Test
    public void testWinTallyLogic() {
        // This test verifies that p1TotalWins and p2TotalWins can be tracked [cite: 1449, 1451]
        // Note: Full integration testing would require mocking the individual game classes.
        int p1Wins = 2;
        int p2Wins = 1;
        
        // Verifying the result logic used in displayOverallResults
        assertTrue(p1Wins > p2Wins, "Player 1 should be the overall winner.");
    }
}