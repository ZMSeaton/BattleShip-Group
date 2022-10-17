import static org.junit.Assert.*;
import org.junit.Test;

public class ShotTests {

    @Test
    public void testMakeShot() throws Exception{
        Shot shot = new Shot("D4");
        assertEquals(shot.getRow(), 3);
        assertEquals(shot.getColumn(), 3);
    }

    @Test
    public void testLegitShot() throws Exception{
        Shot shot = new Shot("a9");
    }

    @Test(expected = Exception.class)
    public void testBogusColumn() throws Exception{
        Shot shot = new Shot("a99");
    }

    @Test(expected = Exception.class)
    public void testBogusEverything() throws Exception{
        Shot shot = new Shot("z99");
    }

    @Test(expected = Exception.class)
    public void testBogusRow() throws Exception{
        Shot shot = new Shot("x9");
    }

}
