import java.util.ArrayList;

public class Ship {
    private String name; //getter
    private int length; //getter
    private int hitCount = 0;
    //private int[][] coordinates;// 
    private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>(); //getter and setter

    public Ship(String name, int length){
        this.name = name;
        this.length = length;
       // this.coordinates = new int[2][length]; //array of arrays holding two ints, first int is row, second is column
    }

    public void registerHit(){ //rename to increase hitCount?
        hitCount++;
    }

    public Boolean isSunk(){
        if(length >= hitCount){
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Coordinate> getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(ArrayList<Coordinate> value){
        coordinates = value;
        

    }

    public String getName(){
        return name;
    }

    public int getLength(){
        return length;
    }

}
