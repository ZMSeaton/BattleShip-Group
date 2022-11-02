import static org.junit.Assert.*;
import org.junit.Test;

public class SuperEasyAITests {
    
    @Test
    public void createAIPlayer(){
        IPlayer superEasyAI = new SuperEasyAI();
    }

    @Test
    public void aiPlayerMakeShot(){
        IPlayer superEasyAI = new SuperEasyAI();
        for (int i = 0; i < 100; i++){ //this will have the aiplayer make every possible shot it can make, none should be the same
            Shot shot = superEasyAI.takeShot();
            System.out.println(shot.getRow() + " " + shot.getColumn());
        }
    }
}
