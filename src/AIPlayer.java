import java.util.Random;
public class AIPlayer implements IPlayer {
Random random=new Random();
String name;

@Override
public String getName() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public Shot takeShot() {
     Shot shot=new Shot(random.nextInt(9),random.nextInt(9));
     return shot;
}

@Override
public boolean allShipsAreSunk() {
    // TODO Auto-generated method stub
    return false;
}

@Override
public ShotResult recieveShot(Shot shot) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void recieveShotResult(ShotResult shotResult, Shot shot) {
    // TODO Auto-generated method stub
    
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
