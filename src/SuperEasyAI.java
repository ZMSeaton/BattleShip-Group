import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperEasyAI implements IPlayer {
    
    private Random random = new Random();
    private List<Shot> shotsTaken = new ArrayList<Shot>();
    private Ship[] ships;

    public SuperEasyAI(){
        ShipBuilder shipBuilder = new ShipBuilder();
        ships = shipBuilder.getShips();
    }

    public String getName(){
        return "Super Easy AI";
    }

    public Shot takeShot(){
        Shot shot;
        while (true){
            shot = new Shot(random.nextInt(0, 10), random.nextInt(0, 10)); //generate new shot
            if (shotsTaken.contains(shot)) { //check if shot has already been made
                continue;
            } else {
                shotsTaken.add(shot); //succesful shot creation
                return shot;
            }
        }
    }

    public boolean allShipsAreSunk(){
        for (Ship ship : ships) {
            if (ship.isSunk() == false){
                return false;
            }
        }
        return true;
    }

    public ShotResult recieveShot(Shot shot){
        for (Ship ship : ships) { //loop through all ships
            for (Coordinate coordinate : ship.getCoordinates()){ //loop through the ship's coordinates
                if ((shot.getRow() == coordinate.getRow()) && (shot.getColumn() == coordinate.getColumn())){ //if shot lines up with a ship's coordinates
                    ship.registerHit();
                    if (ship.isSunk()){
                        ShotResult result = ShotResult.SUNK;
                        result.setSunkShip(ship.getName());
                        return result;
                    } else {
                        return ShotResult.HIT;
                    }
                }
            }
        }
        return ShotResult.MISS;
    }

    public void recieveShotResult(ShotResult shotResult, Shot shot){
        //This AI doesn't care about what it hit, so this method does nothing
    }

}
