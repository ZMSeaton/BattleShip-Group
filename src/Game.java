import java.io.IOException;
import java.util.stream.IntStream;

public class Game {
    private IPlayer[] players = new IPlayer[2];

    private int playerIndex;
    private boolean isGameOver = false;

    public void playGame() throws Exception {

            playerIndex = 0;
            Integer round = 0;
            Shot lastShot = null;
            ShotResult lastShotResult = null;
            IPlayer currentPlayer = players[playerIndex];
            while (isGameOver == false) {

                currentPlayer = players[playerIndex];

                IPlayer opposingPlayer;
                if (playerIndex == 0) {
                    opposingPlayer = players[1];
                } else {
                    opposingPlayer = players[0];
                }
                

                if(round != 0 && currentPlayer instanceof HumanPlayer){
                    turnFeedbackReceiveShot(lastShot, lastShotResult, opposingPlayer);
                } else{
                    //continue;
                }

                // take shot
                Shot s = currentPlayer.takeShot();
                ShotResult result = opposingPlayer.recieveShot(s);// checks other player's grid, returns HIT/MISS/SUNK
                currentPlayer.recieveShotResult(result, s);

            
              
                // give player feedback

                if(currentPlayer instanceof HumanPlayer){
                    turnFeedbackTakeShot(s, result);
                }
                
                //after this feedback, we may want to have player press enter to continue so they have a chance to read the feedback.

                // check for number of sunk ships to see if the game is over.
                if (opposingPlayer.allShipsAreSunk() == true) {
                    isGameOver = true;
                } else {
                    isGameOver = false;
                }
                lastShot = s;
                lastShotResult = result;

                // switch players.
                playerIndex = changePlayerIndex(playerIndex);
                // anticheating display. return to begining of game loop.
                
                if(opposingPlayer instanceof HumanPlayer){
                    if(currentPlayer instanceof HumanPlayer){
                        antiCheatScreen(currentPlayer);
                    }
                }

                round++;

            }

            System.out.println(currentPlayer.getName() + " won!");
        
    }

    public Integer changePlayerIndex(Integer playerIndex) {
        if (playerIndex == 0) {
            playerIndex++;
        } else {
            playerIndex--;
        }
        return playerIndex;

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
                    try {
                        playGame();
                    } catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    return;

                case 4:

                    System.out.println("Thank you for playing Battleship!");
                    System.out.println("+----+----+----+----+----+----+----+");
                    System.exit(0);
            }

        }
    }

    private void createPlayers() {
        int n = determineNumOfPlayers();
        if (n == 2) {

            players[0] = createHumanPlayer();
            players[1] = createHumanPlayer();

        } else {
            players[0] = createHumanPlayer();
            players[1] = createAIPlayers();
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
        SuperEasyAI player = new SuperEasyAI(); //temporarily using my super easy AI while Ben's making his easy AI
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

    private void turnFeedbackTakeShot(Shot shot, ShotResult shotResult) { // only a human player would use this method
        String result;
        switch (shotResult) {
            case MISS:
                result = "missed.";
                break;
            case HIT:
                result = "hit!";
                break;
            case SUNK:
                result = "sunk their " + shotResult.getSunkShip() + ".";
                break;
            default:
                result = "error";
        }
        System.out.println("Your shot at " + shot.getHumanReadable() + " " + result);
    }

    private void turnFeedbackReceiveShot(Shot lastShot, ShotResult lastShotResult, IPlayer opposingPlayer) {
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

    public void antiCheatScreen(IPlayer currentPlayer) {

        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // should send clear screen command to terminal for windows
            }
            else
            {
                Runtime.getRuntime().exec(new String[] {"clear"}); // should send clear screen command to terminals other than windows
            }
            
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            System.out.println("Unsuccesful clearing of screen");
        }

        for (int i = 0; i < 100; i++){ //here just for added security
            System.out.println();
        }
        
        ConsoleHelper.getInput(currentPlayer.getName() + ", press enter to play...");
    }

}
