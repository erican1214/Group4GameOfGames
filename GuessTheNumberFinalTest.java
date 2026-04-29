import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import jdk.jfr.Timestamp;

public class EvenOddFinalTest {
    EvenOdd evenOddGame = new EvenOdd();
    GetInput getInputClass = new GetInput();

    @Test
    public void testValidGuess() {
        assertEquals(true, getInputClass.isInRange(77, 0, 100));
    }

    @Test
    public void testCorrectSum() {
        assertEquals(10, evenOddGame.getSum(5, 5));
    }

    @Test
    public void testCorrectThrow() {
        assertEquals(true, getInputClass.isInRange(3, 1, 5));
    }
}