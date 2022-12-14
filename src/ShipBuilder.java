import java.util.ArrayList;
import java.util.Random;

public class ShipBuilder {

    // Create a set of ships.

    private Ship carrier = new Ship("Aircraft Carrier", 5);
    private Ship battleship = new Ship("Battleship", 4);
    private Ship cruiser = new Ship("Cruiser", 3);
    private Ship submarine = new Ship("Submarine", 3);
    private Ship destroyer = new Ship("Destroyer", 2);

    private Ship[] ships = { carrier, battleship, cruiser, submarine, destroyer };

    private ArrayList<Coordinate> usedCoordinates = new ArrayList<Coordinate>();

    private Random rand = new Random();

    public ShipBuilder(){
        buildShips(ships);
    }

    public Ship[] getShips(){
        return ships;
    }

    private void buildShips(Ship[] ships) {

        for (Ship ship : ships) {

            while (true) {
                // we want to work with a single ship until valid coordinates are created.

                int length = ship.getLength();
                int a = rand.nextInt(11 - length); // limits where coordinate set begins, based on ship length
                int b = rand.nextInt(10); // generates second coordinate. This will be colomn or row.
                Orientation o = Orientation.randomOrientation();
                Coordinate c;

                // use length and orientation to create the first coordinate.
                if (o == Orientation.VERTICAL) {

                    c = new Coordinate(a, b);

                } else {
                    c = new Coordinate(b, a);
                }

                ArrayList<Coordinate> resultingCoordinates = makeCoordinates(c, o, length);
          
                boolean result = checkUsedCoordinates(usedCoordinates, resultingCoordinates);
                //if false continue
                if(result == true){
                    ship.setCoordinates(resultingCoordinates);
                    //add resultingCoordinates to used coordinates
                    usedCoordinates.addAll(resultingCoordinates);
                    break;
                }else{
                    continue;
                }

            
            }

        }

    }

    private boolean checkUsedCoordinates(ArrayList<Coordinate> usedCoordinates,
            ArrayList<Coordinate> resultingCoordinates) {

        for (Coordinate c : resultingCoordinates) {

            if (usedCoordinates.contains(c)) {
                return false;

            }

        }
        return true;
    }

    public ArrayList<Coordinate> makeCoordinates(Coordinate c, Orientation o, int length) {

        ArrayList<Coordinate> returnList = new ArrayList<Coordinate>();
        returnList.add(c);

        for (int i = 1; i < length; i++) {

            Coordinate prev = returnList.get(i - 1);

            if (o == Orientation.HORIZONTAL) {
                // create horizontal set of coordinates: (a, b), (a, b+1)...
                Coordinate nextCoordinate = new Coordinate(prev.getRow(), prev.getColumn() + 1);
                returnList.add(nextCoordinate);

            } else {
                // create vertical set of coordinates
                Coordinate nextCoordinate = new Coordinate(prev.getRow() + 1, prev.getColumn());
                returnList.add(nextCoordinate);
            }
        }

        return returnList;

    }

}
