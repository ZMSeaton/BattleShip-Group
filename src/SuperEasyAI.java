import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperEasyAI implements IPlayer {
    
    private Random random = new Random();
    private List<Shot> shotsTaken = new ArrayList<Shot>();
    private Ship[] ships;
    private Ship lastSunkShip;

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
            shot = new Shot(random.nextInt(0, 10), random.nextInt(0, 10));
            if (shotsTaken.contains(shot)) {
                continue;
            } else {
                shotsTaken.add(shot);
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
        for (Ship ship : ships) {
            for (Coordinate coordinate : ship.getCoordinates()){
                if ((shot.getRow() == coordinate.getRow()) && (shot.getColumn() == coordinate.getColumn())){
                    ship.registerHit();
                    if (ship.isSunk()){
                        lastSunkShip = ship;
                        return ShotResult.SUNK;
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

    public Ship getLastSunkShip(){
        return lastSunkShip;
    }

}
