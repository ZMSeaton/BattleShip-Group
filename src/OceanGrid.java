import java.util.ArrayList;
import java.util.Arrays;

public class OceanGrid extends Grid{

    private ArrayList<Ship> ships;

    public OceanGrid(Ship[] ships){
        super();
        this.ships = new ArrayList<Ship>(Arrays.asList(ships));
        for (Ship ship : this.ships){
            placeShip(ship);
        }
    }

    public void placeShip(Ship ship){ //might change depending on how we decide ship coordinates are stored
        for (int[] coordinates : ship.getCoordinates()){
            cells[coordinates[0]][coordinates[1]].setState(CellState.OCCUPIED);
            cells[coordinates[0]][coordinates[1]].setShip(ship);
        }
    }

}
