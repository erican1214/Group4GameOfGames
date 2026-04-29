# Group4GameOfGames
### By Allan, David, Erica, Valeria


## About
This game is a series of games between two players. Some are player vs. player, some are player vs. computer.

## Game Details and Deployment
### CoinFlip.java
#### Summary
There are two players: Guesser and Flipper. The flipper will "flip" a two sided coin. The guesser will pick if the coind landed on heads or tails. If the guesser is correct, the guesser wins the round. If the guesser is incorrect, the flipper wins the round. Multiple rounds can be played to determine final winner.

#### Deployment
After downloading the file CoinFlip.java, you can run the program as the file has the coinFlip function that has everything to run the game, and the main function which runs the Game. 
If you want to be in the test mode so that you can see which hand the thimble is in, when being asked “Who will be the guesser? Enter 1 for Player 1 and 2 for Player 2, Enter 100 for test mode.” You will be in test mode, and you can see if the coin is heads or tails when asking to guess.

### EvenOdd.java
#### Summary
There are two players. One player will bet on odd and the other player will bet on even. They will each then "throw" a set of fingers from 1-5. The sum of each person's throw will be calculated. If the sum is odd, then the player who chose odd wins the round. If the sum is even, then the player who chose even wins the round. Multiple rounds can be played to determine final winner.

#### Deployment
This file REQUIRES GetInput.java to run properly. Afterwards, the game can be run under the main function. Choice menus are case sensitive.

### FindTheThimble.java
#### Summary
There are two players: Guesser and Hider. The hider will "hide" a thimble in one of the two hands, and the guesser will guess which thimble is in which hand. If the guesser is correct, the guesser wins the round. If the guesser is incorrect, the hider wins the round. Multiple rounds can be played to determine final winner.

#### Deployment
After downloading the file FindTheThimble.java, you can run the program as the file has the findTheThimble function that has everything to run the game, and the main function which runs the Game.

If you want to be in the test mode so that you can see which hand the thimble is in, when being asked “Who will be the guesser? Enter 1 for Player 1 and 2 for Player 2, Enter 100  for test mode.” You will be in test mode, and you can see which hand the thimble is when being asked to guess where the thimble is.

### GetInput.java
#### Summary
Gets and validates inputs from user, such as if integer is within range, or if there was an input mismatch. Error messages will show if input was invalid.

#### Deployment
This file is necessary for EvenOdd.java and GuessTheNumber.java. This file is not meant to be run on its own.

### GuessTheNumber.java
#### Summary
There are two players: Guesser and Selector, and is only player vs. computer. The user will pick a range of values. The user can also pick how many guesses they can have, as long as the number does not exceed half of the range. The user can choose a role between guesser and selector. The selector will pick a target number, and the guesser will guess what it is. If the guesser guesses incorrectly, the selector will say if the target is higher or lower. If the guesser guesses correctly before they run out of guesses, they win the game. Otherwise, the selector wins the game.

#### Deployment
This file REQUIRES GetInput.java to run properly. Afterwards, the game can be run under the main function. Choice menus are case sensitive.

#### FindTheRedThreadFinal.java
Summary
There are two players: Player 1 and Player 2 (Computer). There are 20 spools in a box, one of which is red. Both players choose a number X between 1 and 10, which is how many spools they will pull per turn. Players alternate pulling X spools from the box. The spools are not returned after being pulled. If a player pulls the red spool, that player wins immediately.

#### Deployment
This file REQUIRES GetInput.java to run properly. After downloading both files into the same folder, the game can be run under the main function.

If you want to be in test mode so that you can see where the red spool is in the box, when being asked "Who will pull first? Enter 1 for Player 1 or 2 for Player 2. Enter 100 for TEST mode." enter 100. You will then be in test mode and can see the full box contents and the position of the red spool before each pull.

### PlayGames.java
#### Summary
PlayGames is a menu-driven launcher that allows players to select and play multiple games in a single session. Players can choose between Player vs. Player and Player vs. Computer game modes, then select from a menu of available games. The program tracks overall wins across all games and displays final results when the player quits.

#### Deployment
This file REQUIRES GetInput.java to run properly. All game files (CoinFlip.java, EvenOdd.java, FindTheThimble.java, GuessTheNumber.java, and FindTheRedThreadFinal.java) must be in the same folder. The program can be run under the main function.

Upon startup, you will be prompted to select a game mode:
- Enter 1 for Player vs. Player mode
- Enter 2 for Player vs. Computer mode

After selecting a mode, the main menu will display with the following options:
- 1. Find the Thimble
- 2. Coin Flip
- 3. Guess the Number
- 4. Even and Odd
- 5. Find the Red Thread
- 6. Quit

Select a game by entering the corresponding number. After each game concludes, you will return to the main menu. Enter 6 to quit and view the final tally of overall wins for each player.
