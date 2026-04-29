import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
 
import java.io.*;
 
import static org.junit.jupiter.api.Assertions.*;
 
class EvenOddFinalTest {
 
    // getSum()
 
    @Test
    void getSum_evenPlusEven_isEven() {
        assertEquals(6, EvenOdd.getSum(2, 4));
        assertEquals(0, EvenOdd.getSum(2, 4) % 2);
    }
 
    @Test
    void getSum_oddPlusOdd_isEven() {
        assertEquals(8, EvenOdd.getSum(3, 5));
        assertEquals(0, EvenOdd.getSum(3, 5) % 2);
    }
 
    @Test
    void getSum_evenPlusOdd_isOdd() {
        assertEquals(5, EvenOdd.getSum(2, 3));
        assertEquals(1, EvenOdd.getSum(2, 3) % 2);
    }
 
    @Test
    void getSum_minimumThrows() {
        assertEquals(2, EvenOdd.getSum(1, 1));
    }
 
    @Test
    void getSum_maximumThrows() {
        assertEquals(10, EvenOdd.getSum(5, 5));
    }
 
    @ParameterizedTest(name = "getSum({0}, {1}) == {2}")
    @CsvSource({"1,2,3", "3,4,7", "5,5,10", "1,5,6", "2,3,5"})
    void getSum_parameterised(int a, int b, int expected) {
        assertEquals(expected, EvenOdd.getSum(a, b));
    }
 
    // ---------------------------------------------------------------
    // isInRange() — pure logic in GetInput, no I/O
    // ---------------------------------------------------------------
 
    @Test
    void isInRange_withinRange_returnsTrue() {
        GetInput gi = new GetInput();
        assertTrue(gi.isInRange(3, 1, 5));
    }
 
    @Test
    void isInRange_atMin_returnsTrue() {
        GetInput gi = new GetInput();
        assertTrue(gi.isInRange(1, 1, 5));
    }
 
    @Test
    void isInRange_atMax_returnsTrue() {
        GetInput gi = new GetInput();
        assertTrue(gi.isInRange(5, 1, 5));
    }
 
    @Test
    void isInRange_belowMin_returnsFalse() {
        GetInput gi = new GetInput();
        assertFalse(gi.isInRange(0, 1, 5));
    }
 
    @Test
    void isInRange_aboveMax_returnsFalse() {
        GetInput gi = new GetInput();
        assertFalse(gi.isInRange(6, 1, 5));
    }
 
    // ---------------------------------------------------------------
    // getInputInt() — GetInput returns -1 on non-integer input
    // ---------------------------------------------------------------
 
    @Test
    void getInputInt_validInt_returnsValue() {
        InputStream orig = System.in;
        try {
            System.setIn(new ByteArrayInputStream("4\n".getBytes()));
            assertEquals(4, new GetInput().getInputInt());
        } finally {
            System.setIn(orig);
        }
    }
 
    @Test
    void getInputInt_invalidInput_returnsNegativeOne() {
        InputStream orig    = System.in;
        PrintStream origOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream("abc\n".getBytes()));
            System.setOut(new PrintStream(new ByteArrayOutputStream()));
            assertEquals(-1, new GetInput().getInputInt());
        } finally {
            System.setIn(orig);
            System.setOut(origOut);
        }
    }
 
    // getThrow() — uses GetInput; invalid values re-prompt
 
    private int runGetThrow(String simulatedInput) {
        InputStream originalIn  = System.in;
        PrintStream originalOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
            System.setOut(new PrintStream(new ByteArrayOutputStream()));
            return EvenOdd.getThrow(1, 5);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
 
    @Test
    void getThrow_validInput_returnsValue() {
        assertEquals(3, runGetThrow("3\n"));
    }
 
    @Test
    void getThrow_boundaryMin() {
        assertEquals(1, runGetThrow("1\n"));
    }
 
    @Test
    void getThrow_boundaryMax() {
        assertEquals(5, runGetThrow("5\n"));
    }
 
    @Test
    void getThrow_outOfRange_thenValid() {
        assertEquals(4, runGetThrow("6\n4\n"));
    }
}