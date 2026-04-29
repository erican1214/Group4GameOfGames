public class GuessTheNumber {
    public static void main(String[] args) {
        //Instructions
        System.out.println("Welcome to Guess the Number game!");
        System.out.println("There are two players: Player vs Computer");
        System.out.println("First, the player will pick a range of numbers for the game.");
        System.out.println("Then the player will choose how many guesses can be made. (Must be half range of numbers)");
        System.out.println("Then the selector will pick one of the two roles: Guesser and Selector");
        System.out.println("The Selector will choose a target number, and the Guesser will guess the number.");
        System.out.println("If the Guesser correctly guesses the number before they run out of guesses, the Guesser wins.");
        System.out.println("If the Guesser incorrectly guesses the number, but still have guesses left,");
        System.out.println("The Selector will say if the target number is higher or lower.");
        System.out.println("If the Guesser does not guess the correct number before they run out of guesses, the Selector wins.");
        System.out.println();

        //REQUIRES GetInput.java FILE!
        GetInput getInputClass = new GetInput();
        int min = 0;

        System.out.println("Enter maximum value for the number range:");
        int range = getInputClass.getInputInt();

        // Used -1 as a indicator of InputMismatchException from GetInput class
        while (range == -1 || range <= 0) { 
            if (range <= 0) {
                System.out.println("Enter a positive integer.");
            }
            range = getInputClass.getInputInt();
        }

        int maxGuesses = range / 2;
        System.out.println("How many guesses do you want to make?");
        int desiredGuesses = getInputClass.getInputInt();
        while (desiredGuesses == -1 || !getInputClass.isInRange(desiredGuesses, min, maxGuesses)) {
            if (desiredGuesses <= min) {
                System.out.println("Guesses below the allowed minimum. Try again:");
            }
            else if (desiredGuesses > maxGuesses) {
                System.out.println("Guesses exceed the allowed maximum. Try again:");
            }
            desiredGuesses = getInputClass.getInputInt();
        }

        //No specific variables given to indicate guesser or selector
        System.out.print("Who will be the Guesser? Press 'G' for Guesser, Press 'S' for Selector:");
        String choice = getInputClass.getInputStr();
        while (!choice.equals("G") && !choice.equals("S")) {
            System.out.println("Invalid choice: Press 'G' for Guesser, Press 'S' for Selector:");
            choice = getInputClass.getInputStr();
        }

        if (choice.equals("G")) { //User is guesser
            int target = (int)(Math.random() * range) + 1;
            while (desiredGuesses > 0) {
                System.out.println("Enter your guess:");
                int guess = getInputClass.getInputInt();
                while (guess == -1 || !getInputClass.isInRange(guess, min, range)) {
                    if (!getInputClass.isInRange(guess, min, range)){
                        System.out.println("Guess is out of range. Try again:");
                    }
                    guess = getInputClass.getInputInt();
                }
                if (guess == target) {
                    System.out.println("Guesser WINS!");
                    break;
                }
                else {
                    if (guess < target) {
                        System.out.println("Higher");
                    }
                    else {
                        System.out.println("Lower");
                    }
                    desiredGuesses--;
                }
            }
            if (desiredGuesses == 0) {
                System.out.println("Selector WINS");
            }
        }

        else if (choice.equals("S")) { //User is selector
            int guess = (int)(Math.random() * range) + 1;
            while (desiredGuesses != 0) {
                System.out.println("Guess: " + guess);
                System.out.println("Is this correct? Press 'Y' for 'YES', Press 'N' for 'NO'");
                String correct = getInputClass.getInputStr();
                while (!correct.equals("Y") && !correct.equals("N")) {
                    System.out.println("Invalid answer: Press 'Y' for 'YES', Press 'N' for 'NO'");
                    correct = getInputClass.getInputStr();
                }
                if (correct.equals("Y")) {
                    System.out.println("Guesser WINS");
                    break;
                }
                else if (correct.equals("N")) {
                    System.out.println("Is the target higher or lower? Press 'H' for 'HIGHER', Press 'L for 'LOWER'");
                    String hint = getInputClass.getInputStr();
                    while (!hint.equals("H") && !hint.equals("L")) {
                        System.out.println("Invalid answer: Press 'H' for 'HIGHER', Press 'L' for 'LOWER'");
                        hint = getInputClass.getInputStr();
                    }
                    if (hint.equals("H")) { //Target is higher
                        guess = (int)(Math.random() * (range - guess + 2)) + (guess + 1);
                    }
                    else if (hint.equals("L")) { //Target is lower
                        guess = (int)(Math.random() * (guess - 1)) + 1;
                    }
                    desiredGuesses--;
                }
            }
            if (desiredGuesses == 0) {
                System.out.println("Selector WINS");
            }
        }

    }
};