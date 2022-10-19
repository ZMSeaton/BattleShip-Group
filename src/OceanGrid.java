import java.util.ArrayList;
import java.util.Arrays;

public final class OceanGrid extends Grid{

    private ArrayList<Ship> ships;

    public OceanGrid(Ship[] ships){
        super();
        this.ships = new ArrayList<Ship>(Arrays.asList(ships));
        for (Ship ship : this.ships){
            placeShip(ship);
        }
    }

    @Override
    public void printGrid(){ //label this grid Ocean grid when printing
        System.out.println("Ocean Grid");
        super.printGrid();
    }

    public void placeShip(Ship ship){
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
            cell.setState(CellState.MISS); //updates the cell's state //should this happen here?
            return ShotResult.MISS;
        } else if ( cell.getState() == CellState.OCCUPIED ) {
            cell.getShip().registerHit(); //Should this be where ship is hit?
            cell.setState(CellState.HIT); //updates the cell's state //should this happen here?
            if (cell.getShip().isSunk()){
                return ShotResult.SUNK;
            } else {
                return ShotResult.HIT;
            }
        } else {
            return null; //shouldn't be able to happen
        }
    }

    public Boolean isAllShipsSunk(){
        for(Ship ship : ships){
            if (ship.isSunk() == false){
                return false;
            }
        }
        return true;
    }

}
