public class App {
    public static void main(String[] args) throws Exception {

        Game game = new Game();

        HumanPlayer player = new HumanPlayer("name");
        for (int i = 0; i < 99; i++){
            System.out.println(i);
        }
        game.antiCheatScreen(player);


    }
}
   