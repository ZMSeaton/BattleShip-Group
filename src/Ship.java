import java.util.ArrayList;

public final class Ship {
    private String name; // getter
    private int length; // getter
    private int hitCount = 0;
    private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>(); // getter and setter

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void registerHit() {
        hitCount++;
    }

    public Boolean isSunk() {
        if (hitCount < length) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> value) { // Have in constructor?
        coordinates = value;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

}
