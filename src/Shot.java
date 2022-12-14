import java.util.Objects;

public final class Shot {
    private int row;
    private int column;

    public Shot(String humanValue) throws Exception { //makes shot from human typed value
        String humanValueCleaned = (humanValue.replaceAll(" ", "")).toLowerCase(); //make everything lowercase and remove any spaces
        row = humanToComputerRow(humanValueCleaned);
        column = humanToComputerColumn(humanValueCleaned);
    }

    public Shot(int row, int column){
        this.row = row;
        this.column = column;
    }

    private int humanToComputerRow(String humanValue) throws Exception {
        char rowChar = humanValue.charAt(0);
        int rowIndex = (int)rowChar - 97; // 97 is the ascii number for a
        if ((rowIndex < 0) || (rowIndex > 9)){
            throw new Exception("Row out of range.");
        }
        return rowIndex;
    }

    private int humanToComputerColumn(String humanValue) throws Exception {
        String columnString = humanValue.substring(1);
        int columnIndex;
        try {
            columnIndex = Integer.parseInt(columnString) - 1;
        } catch (NumberFormatException e){
            throw new Exception("Invalid column for shot.");
        }
        if ((columnIndex < 0) || (columnIndex > 9)){
            throw new Exception("Column out of range.");
        }
        return columnIndex;
    }

    public String getHumanReadable(){
        char row = (char)(65 + this.row); //65 is ascii for A
        int column = this.column + 1; //It's zero indexed, so to make it human readable, add 1
        String humanReadable = Character.toString(row) + Integer.toString(column);
        return humanReadable;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
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
        Shot shot = (Shot) o;
        // field comparison
        return Objects.equals(this.row, shot.getRow())// row
                && Objects.equals(this.column, shot.getColumn());// column
    }

}
