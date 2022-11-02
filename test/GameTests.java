import static org.junit.Assert.*;
import org.junit.Test;

public class GameTests {
    
    @Test
    public void testClearScreen(){
        Game game = new Game();
        HumanPlayer player = new HumanPlayer("name");
        for (int i = 0; i < 99; i++){
            System.out.println(i);
        }
        game.antiCheatScreen(player); //NOTE, this does work, but not in the debug menu for some reason
    }
    

    
}
