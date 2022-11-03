import static org.junit.Assert.*;
import org.junit.Test;

public class GameClassTests {
    
    @Test
    public void testChangePlayerIndex1(){
        Game game = new Game();
        Integer playerIndex = 0;
        game.changePlayerIndex(playerIndex);
        Integer a = 1;
        assertTrue(a.equals(playerIndex));

    }

    @Test
    public void testChangePlayerIndex0(){
        Game game = new Game();
        Integer playerIndex = 1;
        game.changePlayerIndex(playerIndex);
        Integer a = 0;
        assertTrue(a.equals(playerIndex));

    }



}
