
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testShipBuilder {

    @Test
    public void testMakeCoordinates() {
        // set up what I need
        // run method under test
        // verify correct answer

        ShipBuilder fleet = new ShipBuilder();
        Coordinate c = new Coordinate(3, 2);
        Orientation o = Orientation.HORIZONTAL;
        int length = 4;

        ArrayList<Coordinate> expectedArrayList = new ArrayList<Coordinate>() {
            {
                add(new Coordinate(3, 2));
                add(new Coordinate(3, 3));
                add(new Coordinate(3, 4));
                add(new Coordinate(3, 5));
            }
        };

        ArrayList<Coordinate> testList = fleet.makeCoordinates(c, o, length);

        assertEquals(length, testList.size());
        assertEquals(expectedArrayList, testList);
    }

    @Test
    public void testShipPlacing() throws Exception {

        ShipBuilder shipBuilder = new ShipBuilder();

        for (Ship ship : shipBuilder.getShips()) {

            System.out.println(ship.getName());

            for (Coordinate coord : ship.getCoordinates()) {

                if ((coord.getRow() < 0) || (coord.getRow() > 9)) {
                    throw new Exception("Row is out of bounds: " + coord.getRow());
                } else if ((coord.getColumn() < 0) || (coord.getColumn() > 9)) {
                    throw new Exception("Column is out of bounds: " + coord.getColumn());
                }

                System.out.println(coord.getRow() + " " + coord.getColumn());

            }
        }
    }
}
