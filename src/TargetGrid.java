public final class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    @Override
    public void printGrid(){ //label this grid Target grid when printing
        System.out.println("Target Grid");
        super.printGrid();
    }

    public Boolean isShotValid(int row, int column) {
        if (cells[row][column].getState() == CellState.EMPTY) {
            return true;
        } else {
            return false;
        }
    }

    public void updateTargetGrid(Shot shot, ShotResult result){
        switch(result){
            case HIT -> cells[shot.getRow()][shot.getColumn()].setState(CellState.HIT);
            case SUNK -> cells[shot.getRow()][shot.getColumn()].setState(CellState.HIT);
            case MISS -> cells[shot.getRow()][shot.getColumn()].setState(CellState.MISS);
        }
    }

}
