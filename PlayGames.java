public class PlayGames {
    private static final int QUIT = 6;
    private static final int THIMBLE = 1;
    private static final int COIN_FLIP = 2;
    private static final int GUESS_NUM = 3;
    private static final int EVEN_ODD = 4;
    private static final int RED_THREAD = 5;

    public static void main(String[] args) {
        // Instantiate teammate's GetInput class
        GetInput inputUtility = new GetInput();
        
        System.out.println("--- Welcome to the Game of Games ---");

        // Use methods from GetInput for initial setup
        System.out.print("Select Game Mode (1. Player vs. Player, 2. Player vs. Computer): ");
        int gameMode = inputUtility.getInputInt();
        while (true) {
            if (gameMode == 1 || gameMode == 2) {
                break;
            } else {
                System.out.println("Invalid selection. Please enter 1 or 2.");
                gameMode = inputUtility.getInputInt();
            }
        }

        int p1TotalWins = 0;
        int p2TotalWins = 0;
        boolean keepRunning = true;

        while (keepRunning) {
            displayMainMenu();
            int choice = inputUtility.getInputInt();

            // Validate menu choice using inputUtility's  isInRange
            while (true) {
                if (choice >= 1 && choice <= QUIT) {
                    break;
                } else {
                    System.out.println("Invalid menu choice. Please enter an integer between 1-6.");
                    choice = inputUtility.getInputInt();
                }
            }

            if (choice == QUIT) {
                displayOverallResults(p1TotalWins, p2TotalWins);
                keepRunning = false;
            } else {
                int winner = launchGame(choice, gameMode);
                if (winner == 1) {
                    p1TotalWins++;
                } else if (winner == 2) {
                    p2TotalWins++;
                }
                // After launchGame returns, display the game-specific scoreboard
                System.out.println("\n[System] Returning to Main Menu...");
                System.out.println("Current Tally - Player 1: " + p1TotalWins + " | Player 2/Computer: " + p2TotalWins);
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Find the Thimble");
        System.out.println("2. Coin Flip");
        System.out.println("3. Guess the Number");
        System.out.println("4. Even and Odd");
        System.out.println("5. Find the Red Thread");
        System.out.println("6. Quit");
    }

    private static int launchGame(int choice, int mode) {
        // Implementation for each game class goes here
        if (choice == THIMBLE) {
            return FindTheThimble.findTheThimble();
        } else if (choice == COIN_FLIP) {
            return CoinFlip.coinFlip();
        } else if (choice == GUESS_NUM) {
            return GuessTheNumber.playGame();
        } else if (choice == EVEN_ODD) {
            return EvenOdd.playGame();
        } else if (choice == RED_THREAD) {
            return FindTheRedThreadFinal.play();
        }
        return 0;
    }

    private static void displayOverallResults(int p1, int p2) {
        System.out.println("\n--- FINAL TALLY ---");
        System.out.println("Player 1 Overall Wins: " + p1);
        System.out.println("Player 2/Computer Overall Wins: " + p2);
        
        if (p1 > p2) System.out.println("OVERALL WINNER: Player 1");
        else if (p2 > p1) System.out.println("OVERALL WINNER: Player 2/Computer");
        else System.out.println("OVERALL RESULT: It's a Tie!");
    }
}