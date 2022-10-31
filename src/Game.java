import java.io.IOException;

public class Game {
    private IPlayer[] players = new IPlayer[2];
    private int playerIndex;

    public void playGame() throws Exception {
        
    }

    public static void handleStartUpOption() throws Exception {

        while(true){

            printStartScreen();
            int n = ConsoleHelper.convertInputToNumber("Please enter your choice (1-4): ", " Please choose between options 1 through 4.", 1, 4);
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
                    determineNumOfPlayers();
                    break;

                case 4:

                    System.out.println("Thank you for playing Battleship!");
                    System.out.println("+----+----+----+----+----+----+----+");
                    System.exit(0);
            }

        }
    }   

    private static void determineNumOfPlayers() throws Exception {

        int numberOfPlayer = ConsoleHelper.convertInputToNumber("Please enter the number of players (1 or 2): ", "Please choose 1 or 2 players.", 1, 2);

        if (numberOfPlayer == 1) {
            // create 1 humanPlayer and ask about game difficulty for AI

            System.out.println("This will create a single player game");
            Demo.gameDemo();

        } else {
            // create 2 humanPlayers
            System.out.println("This will create a two player game.");
            Demo.gameDemo();

        }

    }

    private static void printStartScreen() {
        System.out.println("Welcome to Battleship!");
        System.out.println("Please choose from the following options:");
        System.out.println("1. Show the rules");
        System.out.println("2. Show the scoreboard");
        System.out.println("3. Play Battleship");
        System.out.println("4. Exit the game");

    }

    private void turnFeedbackTakeShot(Shot shot, ShotResult shotResult, Ship sunkShip){ //only a human player would use this method //hand method null if ship wasn't sunk
        String result;
        switch(shotResult){
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

    private void turnFeedbackReceiveShot(Shot lastShot, ShotResult lastShotResult, HumanPlayer currentPlayer, IPlayer opposingPlayer){ //only a human player would use this method
        String result;
        switch(lastShotResult){
            case MISS:
                result = "missed your ships.";
                break;
            case HIT:
                result = "hit a ship!";
                break;
            case SUNK:
                result = "sunk your " + currentPlayer.getLastSunkShip();
                break;
            default:
                result = "error";
        }
        System.out.println(opposingPlayer.getName() + "'s shot at " + lastShot.getHumanReadable() + " " + result);
    }

    private void antiCheatScreen(HumanPlayer currentPlayer){ //only a human player would use this method
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //should send clear screen command to terminal
        } catch (Exception exception){
            System.out.println("Unsuccesful clearing of screen");
        }
        ConsoleHelper.getInput("Press enter to play...");
    }

}
