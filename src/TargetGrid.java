public class TargetGrid extends Grid {
    
    public TargetGrid(){
        super();
    }

    public Boolean isShotValid(int row, int column){
        if (cells[row][column].getState() == CellState.EMPTY){
            return true;
        } else {
            return false;
        }
    }

}
