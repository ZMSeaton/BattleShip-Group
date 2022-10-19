public class App {
    public static void main(String[] args) throws Exception {
        //just some test code
        HumanPlayer testHumanPlayer = new HumanPlayer("Test1");
        HumanPlayer testOpponentHumanPlayer = new HumanPlayer("Test2");
        Shot shot;
        ShotResult shotResult;
        boolean isGameOver = false;

        while (isGameOver == false){

            testHumanPlayer.printGrids();
            shot = testHumanPlayer.takeShot();
            shotResult = testOpponentHumanPlayer.recieveShot(shot);
            testHumanPlayer.recieveShotResult(shotResult, shot);

            if (shotResult == ShotResult.SUNK){
                System.out.println("You sunk their " + testOpponentHumanPlayer.getLastSunkShip().getName() + "!");;
            }

            if(testOpponentHumanPlayer.allShipsAreSunk()){
                isGameOver = true;
            }

        }
        
    }
}
