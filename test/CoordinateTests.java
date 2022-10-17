import static org.junit.Assert.*;
import org.junit.Test;

public class CoordinateTests {

    @Test
    public void testCoordinateEquality(){
        Coordinate a = new Coordinate(3,2);
        Coordinate b = new Coordinate(3,2);
        assertTrue(a.equals(b));
    }
    
    @Test
    public void testCoordinateInequality(){
        Coordinate a = new Coordinate(3,2);
        Coordinate b = new Coordinate(3,3);
        assertFalse(a.equals(b));
    }
}
