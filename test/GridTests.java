import static org.junit.Assert.*;
import org.junit.Test;

public class GridTests {
    
    @Test
    public void createOceanGrid(){
        OceanGrid oceanGrid = new OceanGrid(new Ship[] {new Ship("TestShip", 3)});
    }

    @Test
    public void testOceanPrintBoard(){
        ShipBuilder shipBuilder = new ShipBuilder();
        OceanGrid oceanGrid = new OceanGrid(shipBuilder.getShips());
        oceanGrid.printGrid();
    }

    @Test
    public void testTargetPrintBoard(){
        TargetGrid targetGrid = new TargetGrid();
        targetGrid.printGrid();
    }

    @Test
    public void testTargetGridIsShotValid(){
        TargetGrid targetGrid = new TargetGrid();
        assertTrue(targetGrid.isShotValid(5, 5));
    }

}
