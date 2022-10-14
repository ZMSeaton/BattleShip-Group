import java.util.Objects;

public class Coordinate {

    private int row;
    private int column;

    // constructor
    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        // instance variables are what was sent in

    }

    public int getRow() {
        return row;

    }

    public int getColumn() {
        return column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Coordinate coordinate = (Coordinate) o;
        // field comparison
        return Objects.equals(this.row, coordinate.row)// row
                && Objects.equals(this.column, coordinate.column);// column
    }

}
