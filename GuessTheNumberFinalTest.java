import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import jdk.jfr.Timestamp;

public class GuessTheNumberFinalTest {
    GuessTheNumber guessTheNumberGame = new GuessTheNumber();
    GetInput getInputClass = new GetInput();

    @Test
    public void testValidGuess() {
        assertEquals(true, getInputClass.isInRange(77, 0, 100));
    }
}