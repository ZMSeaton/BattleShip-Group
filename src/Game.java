import java.io.IOException;
import java.util.stream.IntStream;

public class Game {
    private IPlayer[] players = new IPlayer[2];

    private int playerIndex;
    private boolean isGameOver = false;

    public void playGame() throws Exception {

        for (IPlayer player : players) {

            while (isGameOver == false) {

                // take shot

                // give player feedback

                // switch players.
                // anticheating display. return to begining of game loop.

            }
        }
    }

    public void handleStartUpOption() {

        while (true) {

            printStartScreen();
            int n = ConsoleHelper.convertInputToNumber("Please enter your choice (1-4): ",
                    " Please choose between options 1 through 4.", 1, 4);
            // this should prompt the player for their choice until a valid choice is made.

            switch (n) {

                case 1:
                    System.out.println("Rule printing will be implemented later.");
                    System.out.println("+----+----+----+----+----+----+----+");
                    break;

                case 2:
                    System.out.println("Scoreboard will be implemented later.");
                    System.out.println("+----+----+----+----+----+----+----+");
                    break;

                case 3:
                    System.out.println("Let's play some Battleship!");
                    System.out.println("+----+----+----+----+----+----+----+");
                    createPlayers();
                    break;

                case 4:

                    System.out.println("Thank you for playing Battleship!");
                    System.out.println("+----+----+----+----+----+----+----+");
                    System.exit(0);
            }

        }
    }

    private void createPlayers(){
        int n = determineNumOfPlayers();
        if(n==2){
            
           players[0]= createHumanPlayer();
           players[1]= createHumanPlayer();
            

        }else{
          players[0]= createHumanPlayer();
          players[1]= createAIPlayers();

        }
       
    }

    private int determineNumOfPlayers() {

        int numberOfPlayer = ConsoleHelper.convertInputToNumber("Please enter the number of players (1 or 2): ",
                "Please choose 1 or 2 players.", 1, 2);
        return numberOfPlayer;

    }

    private IPlayer createHumanPlayer() {
        String name = ConsoleHelper.getInput("Please enter the name of Player 1: ");
        HumanPlayer player = new HumanPlayer(name);
        return player;

    }

    private IPlayer createAIPlayers() {
        // ask for difficulty when we have more than 1 AI to play with
        AIPlayer player = new AIPlayer();
        return player;

    }

    private void printStartScreen() {
        System.out.println("Welcome to Battleship!");
        System.out.println("Please choose from the following options:");
        System.out.println("1. Show the rules");
        System.out.println("2. Show the scoreboard");
        System.out.println("3. Play Battleship");
        System.out.println("4. Exit the game");

    }

    private void turnFeedbackTakeShot(Shot shot, ShotResult shotResult, Ship sunkShip) { // only a human player would
                                                                                         // use this method //hand
                                                                                         // method null if ship wasn't
                                                                                         // sunk
        String result;
        switch (shotResult) {
            case MISS:
                result = "missed.";
                break;
            case HIT:
                result = "hit!";
                break;
            case SUNK:
                result = "sunk their " + sunkShip.getName();
                break;
            default:
                result = "error";
        }
        System.out.println("You're shot at " + shot.getHumanReadable() + " " + result);
    }

    private void turnFeedbackReceiveShot(Shot lastShot, ShotResult lastShotResult,
            IPlayer opposingPlayer) { // only a human player would use this method
        String result;
        switch (lastShotResult) {
            case MISS:
                result = "missed your ships.";
                break;
            case HIT:
                result = "hit a ship!";
                break;
            case SUNK:
                result = "sunk your " + lastShotResult.getSunkShip() + "!";
                break;
            default:
                result = "error";
        }
        System.out.println(opposingPlayer.getName() + "'s shot at " + lastShot.getHumanReadable() + " " + result);
    }

    private void antiCheatScreen(HumanPlayer currentPlayer) { // only a human player would use this method
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // should send clear screen command to
                                                                                  // terminal
        } catch (Exception exception) {
            System.out.println("Unsuccesful clearing of screen");
        }
        ConsoleHelper.getInput("Press enter to play...");
    }

}
