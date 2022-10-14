import java.util.Random;

public enum Orientation {

    HORIZONTAL,
    VERTICAL;


private static Random PRNG = new Random();


//We can call this method to generate a random orientation: Orientation orientation = Orientation.randomOrientation();
public static Orientation randomOrientation(){
    
    Orientation[] orientations = values();
    return orientations[PRNG.nextInt(orientations.length)];
}


    
}
