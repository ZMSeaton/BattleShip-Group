import java.util.Random;
public class AIPlayer implements IPlayer {
Random random=new Random();
protected String name;
protected ShipBuilder shipBuilder = new ShipBuilder();
protected OceanGrid oceanGrid;
protected TargetGrid targetGrid;

public AIPlayer(String name) {
    this.name = name;
    oceanGrid = new OceanGrid(shipBuilder.getShips());
    targetGrid = new TargetGrid();
}
@Override
public String getName() {
   return name;
}

@Override
public Shot takeShot() {
     Shot shot=new Shot(random.nextInt(10),random.nextInt(10));
     while (true){
     if (targetGrid.isShotValid(shot.getRow(), shot.getColumn())) {
        return shot;
    } else {
      
        continue;
    }}
}

@Override
public boolean allShipsAreSunk() {
    if (oceanGrid.isAllShipsSunk()) {
        return true;
    }
    return false;
}

@Override
public ShotResult recieveShot(Shot gotshot) {
    return oceanGrid.getShotResult(gotshot);
}

@Override
public void recieveShotResult(ShotResult shotResult, Shot shot) {
    targetGrid.updateTargetGrid(shot, shotResult);
    
}




/// public String get_name() {
//// return name;
/// }

/// public Shot takeShot() {

/// }

/// public boolean allShipsAreSunk() {

    }
///}
///*/ //Temporarily commented out to avoid java complaints
