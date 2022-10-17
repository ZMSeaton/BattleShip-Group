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
        for (Coordinate coordinates : ship.getCoordinates()){
            cells[coordinates.getRow()][coordinates.getColumn()].setState(CellState.OCCUPIED);
            cells[coordinates.getRow()][coordinates.getColumn()].setShip(ship);
        }
    }

    public ArrayList<Ship> getShips(){
        return ships;
    }

    public ShotResult getShotResult(Shot shot){
        Cell cell = cells[shot.getRow()][shot.getColumn()];
        if ( cell.getState() == CellState.EMPTY){
            return ShotResult.MISS;
        } else if ( cell.getState() == CellState.OCCUPIED ) {
            cell.getShip().registerHit(); //Should this be where ship is hit?
            if (cell.getShip().isSunk()){
                return ShotResult.SUNK;
            } else {
                return ShotResult.HIT;
            }
        } else {
            return null; //shouldn't be able to happen
        }
    }

}
