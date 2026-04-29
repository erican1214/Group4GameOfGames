import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for GuessTheNumber.java
 *
 * GetInput behavior recap:
 *  - getInputInt()  → new Scanner each call; returns -1 on non-integer input
 *  - getInputStr()  → new Scanner each call; reads one whitespace-delimited token
 *  - isInRange()    → pure boolean logic, no I/O
 *
 * playGame() input order:
 *   1. range          (positive integer)
 *   2. desiredGuesses (1 .. range/2)
 *   3. role           (G = player is Guesser | S = player is Selector)
 *
 *   IF role == G (player guesses):
 *     Repeat until win or guesses exhausted:
 *       - guess (integer 1..range)
 *     Returns 1 if player guessed correctly, 2 if computer wins.
 *
 *   IF role == S (player is Selector, computer guesses):
 *     Repeat until computer guesses right or guesses exhausted:
 *       - Y / N  (is computer's guess correct?)
 *       - if N: H / L  (is target higher or lower?)
 *     Returns 2 if computer wins (Y), 1 if guesses exhausted (player wins).
 *
 * NOTE: Because the computer's target (G-path) and first guess (S-path) are
 * random, integration tests for playGame() cannot deterministically control
 * the game outcome. Tests therefore exercise input-validation loops and
 * the Selector path (where the player fully controls Y/N/H/L responses).
 * The pure-logic helpers (isInRange, getInputInt) are tested directly.
 *
 * Compile & run:
 *   javac -cp junit-platform-console-standalone.jar *.java
 *   java  -cp .:junit-platform-console-standalone.jar \
 *         org.junit.platform.console.standalone.ConsoleLauncher \
 *         --select-class=GuessTheNumberTest
 */
class GuessTheNumberFinalTest {

    // ---------------------------------------------------------------
    // isInRange()
    // ---------------------------------------------------------------

    @Test
    @DisplayName("isInRange: value inside range returns true")
    void isInRange_inside_returnsTrue() {
        assertTrue(new GetInput().isInRange(5, 1, 10));
    }

    @Test
    @DisplayName("isInRange: minimum boundary returns true")
    void isInRange_atMin_returnsTrue() {
        assertTrue(new GetInput().isInRange(0, 0, 10));
    }

    @Test
    @DisplayName("isInRange: maximum boundary returns true")
    void isInRange_atMax_returnsTrue() {
        assertTrue(new GetInput().isInRange(10, 0, 10));
    }

    @Test
    @DisplayName("isInRange: value below min returns false")
    void isInRange_belowMin_returnsFalse() {
        assertFalse(new GetInput().isInRange(-1, 0, 10));
    }

    @Test
    @DisplayName("isInRange: value above max returns false")
    void isInRange_aboveMax_returnsFalse() {
        assertFalse(new GetInput().isInRange(11, 0, 10));
    }

    // ---------------------------------------------------------------
    // getInputInt() — returns -1 on non-integer input
    // ---------------------------------------------------------------

    @Test
    @DisplayName("getInputInt: valid integer returned correctly")
    void getInputInt_valid_returnsValue() {
        InputStream orig = System.in;
        try {
            System.setIn(new ByteArrayInputStream("7\n".getBytes()));
            assertEquals(7, new GetInput().getInputInt());
        } finally {
            System.setIn(orig);
        }
    }

    @Test
    @DisplayName("getInputInt: non-integer input returns -1 sentinel")
    void getInputInt_invalid_returnsNegativeOne() {
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
}
