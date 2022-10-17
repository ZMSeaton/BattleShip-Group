import static org.junit.Assert.*;
import org.junit.Test;

public class GridTests {
    
    @Test
    public void createOceanGrid(){
        OceanGrid oceanGrid = new OceanGrid(new Ship[] {new Ship("TestShip", 3)});
    }

    @Test
    public void testOceanPrintBoard(){
        OceanGrid oceanGrid = new OceanGrid();
        oceanGrid.printGrid();
    }

    @Test
    public void testTargetPrintBoard(){
        TargetGrid targetGrid = new TargetGrid();
        targetGrid.printGrid();
    }
}
