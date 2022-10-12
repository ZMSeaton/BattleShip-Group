public class Shot {
    private int row;
    private int column;

    public Shot(String humanValue) throws Exception {
        String humanValueCleaned = (humanValue.replaceAll(" ", "")).toLowerCase(); //make everything lowercase and remove any spaces
        row = humanToComputerRow(humanValueCleaned);
        column = humanToComputerColumn(humanValueCleaned);
    }

    private int humanToComputerRow(String humanValue) throws Exception {
        char rowChar = humanValue.charAt(0);
        int rowIndex = (int)rowChar - 97; // 97 is the ascii number for a
        if ((rowIndex < 0) || (rowIndex > 9)){
            throw new Exception("Invalid row for shot.");
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
            throw new Exception("Invalid column for shot.");
        }
        return columnIndex;
    }

    public String getHumanReadable(int rowIndex, int columnIndex){
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
}
