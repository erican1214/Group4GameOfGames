import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EvenOddFinalTest {

    @Test
    void testGetSum() {
        assertEquals(5, EvenOdd.getSum(2, 3));
        assertEquals(10, EvenOdd.getSum(5, 5));
        assertEquals(2, EvenOdd.getSum(1, 1));
    }

    @Test
    void testEvenSum() {
        int sum = EvenOdd.getSum(2, 4);
        assertTrue(sum % 2 == 0, "Sum should be even");
    }

    @Test
    void testOddSum() {
        int sum = EvenOdd.getSum(3, 2);
        assertTrue(sum % 2 == 1, "Sum should be odd");
    }

    @Test
    void testDetermineWinner_Player1EvenWins() {
        int winner = EvenOdd.determineWinner("E", 2, 4); // sum = 6 (even)
        assertEquals(1, winner);
    }

    @Test
    void testDetermineWinner_Player2WinsWhenMismatch() {
        int winner = EvenOdd.determineWinner("E", 3, 2); // sum = 5 (odd)
        assertEquals(2, winner);
    }
}

