public class Grid {
    
    protected Cell cells[][] = new Cell[10][10];

    public Grid(){
        for(int row = 0; row < 10; row ++){ //Initially fill every cell with an empty state  
            for(int col = 0; col < 10; col ++){
                cells[row][col] = new Cell();
                cells[row][col].setState(CellState.EMPTY);
            }
        }
    }

    public void printGrid(){

        printHeader();

        for (int row = 0; row < 10; row++){

            printHorizontalDivider();

            System.out.print("| " + (char)(65 + row) + " "); //65 is the ascii number for capital A
            for (int column = 0; column < 10; column++){
                System.out.print(String.format("| %s ", contentDisplay(cells[row][column])));
            }
            System.out.println("|");

        }

        printHorizontalDivider();
    }

    private void printHorizontalDivider(){
        for (int ii = 0; ii < 11; ii++){
            System.out.print("+---");
        }
        System.out.println("+");
    }

    private void printHeader(){
        printHorizontalDivider();
        System.out.println("|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
    }

    protected String contentDisplay(Cell cell){ //Might change depending on how we decide to display grid contents
        CellState state = cell.getState();
        if (state == CellState.EMPTY){
            return " ";
        } else if (state == CellState.HIT){
            return "X";
        } else if (state == CellState.MISS){
            if (this instanceof OceanGrid){ //When displaying misses for ocean grid, it will display a lowercase o, if the grid is not an ocean grid, it will display an uppercase one
                return "o";
            }
            return "O";
        } else if (state == CellState.OCCUPIED){
            return String.valueOf(cell.getShip().getName().charAt(0)); //Displays first letter of ship
        } else {
            return "Invalid CellState";
        }
    }

}
