import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for EvenOdd.java
 *
 * NOTE on GetInput behavior:
 *  - getInputInt() creates a NEW Scanner each call and returns -1 on non-integer input.
 *  - getInputStr() creates a NEW Scanner each call and reads one token.
 *  - Because each Scanner is fresh, System.in must be fully pre-loaded with
 *    newline-separated tokens in the exact order the game will request them.
 *
 * Compile & run (from directory containing all .java files):
 *   javac -cp junit-platform-console-standalone.jar *.java
 *   java  -cp .:junit-platform-console-standalone.jar \
 *         org.junit.platform.console.standalone.ConsoleLauncher \
 *         --select-class=EvenOddTest
 */
class EvenOddFinalTest {

    // ---------------------------------------------------------------
    // getSum() — pure arithmetic, no I/O
    // ---------------------------------------------------------------

    @Test
    @DisplayName("getSum: even + even = even")
    void getSum_evenPlusEven_isEven() {
        assertEquals(6, EvenOdd.getSum(2, 4));
        assertEquals(0, EvenOdd.getSum(2, 4) % 2);
    }

    @Test
    @DisplayName("getSum: odd + odd = even")
    void getSum_oddPlusOdd_isEven() {
        assertEquals(8, EvenOdd.getSum(3, 5));
        assertEquals(0, EvenOdd.getSum(3, 5) % 2);
    }

    @Test
    @DisplayName("getSum: even + odd = odd")
    void getSum_evenPlusOdd_isOdd() {
        assertEquals(5, EvenOdd.getSum(2, 3));
        assertEquals(1, EvenOdd.getSum(2, 3) % 2);
    }

    @Test
    @DisplayName("getSum: minimum throws (1 + 1 = 2)")
    void getSum_minimumThrows() {
        assertEquals(2, EvenOdd.getSum(1, 1));
    }

    @Test
    @DisplayName("getSum: maximum throws (5 + 5 = 10)")
    void getSum_maximumThrows() {
        assertEquals(10, EvenOdd.getSum(5, 5));
    }

    @ParameterizedTest(name = "getSum({0}, {1}) == {2}")
    @CsvSource({"1,2,3", "3,4,7", "5,5,10", "1,5,6", "2,3,5"})
    @DisplayName("getSum: parameterised correctness")
    void getSum_parameterised(int a, int b, int expected) {
        assertEquals(expected, EvenOdd.getSum(a, b));
    }

    // ---------------------------------------------------------------
    // isInRange() — pure logic in GetInput, no I/O
    // ---------------------------------------------------------------

    @Test
    @DisplayName("isInRange: value within range returns true")
    void isInRange_withinRange_returnsTrue() {
        GetInput gi = new GetInput();
        assertTrue(gi.isInRange(3, 1, 5));
    }

    @Test
    @DisplayName("isInRange: minimum boundary returns true")
    void isInRange_atMin_returnsTrue() {
        GetInput gi = new GetInput();
        assertTrue(gi.isInRange(1, 1, 5));
    }

    @Test
    @DisplayName("isInRange: maximum boundary returns true")
    void isInRange_atMax_returnsTrue() {
        GetInput gi = new GetInput();
        assertTrue(gi.isInRange(5, 1, 5));
    }

    @Test
    @DisplayName("isInRange: value below range returns false")
    void isInRange_belowMin_returnsFalse() {
        GetInput gi = new GetInput();
        assertFalse(gi.isInRange(0, 1, 5));
    }

    @Test
    @DisplayName("isInRange: value above range returns false")
    void isInRange_aboveMax_returnsFalse() {
        GetInput gi = new GetInput();
        assertFalse(gi.isInRange(6, 1, 5));
    }

    // ---------------------------------------------------------------
    // getInputInt() — GetInput returns -1 on non-integer input
    // ---------------------------------------------------------------

    @Test
    @DisplayName("getInputInt: valid integer is returned correctly")
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
    @DisplayName("getInputInt: non-integer input returns -1 (sentinel for invalid)")
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

    // ---------------------------------------------------------------
    // getThrow() — uses GetInput internally; invalid values re-prompt
    // ---------------------------------------------------------------

    @Test
    @DisplayName("getThrow: valid in-range input accepted immediately")
    void getThrow_validInput_returnsValue() {
        assertEquals(3, runGetThrow("3\n"));
    }

    @Test
    @DisplayName("getThrow: boundary value 1 accepted")
    void getThrow_boundaryMin() {
        assertEquals(1, runGetThrow("1\n"));
    }

    @Test
    @DisplayName("getThrow: boundary value 5 accepted")
    void getThrow_boundaryMax() {
        assertEquals(5, runGetThrow("5\n"));
    }

    @Test
    @DisplayName("getThrow: out-of-range input (6) rejected, valid retry (4) accepted")
    void getThrow_outOfRange_thenValid() {
        assertEquals(4, runGetThrow("6\n4\n"));
    }
}