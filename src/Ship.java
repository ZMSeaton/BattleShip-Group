public class Ship {
    private String name;
    private int length;
    private int hitCount = 0;
    private int[][] coordinates;

    public Ship(String name, int length){
        this.name = name;
        this.length = length;
        this.coordinates = new int[2][length]; //array of arrays holding two ints, first int is row, second is column, change if we decide to hold coordinates differently
    }

    public void hit(){ //rename to increase hitCount?
        hitCount++;
    }

    public Boolean isSunk(){
        if(length >= hitCount){
            return false;
        } else {
            return true;
        }
    }

    public int[][] getCoordinates(){
        return coordinates;
    }

    public void enterCoordinates(int[][] coordinates){
        this.coordinates = coordinates;
    }

    public String getName(){
        return name;
    }

}
