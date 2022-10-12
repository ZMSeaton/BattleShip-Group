public class Cell {
    private CellState cell_state;
    private Ship ship;

    public CellState getState() {
        return cell_state;
    }
    
    public void setState(CellState cell_state)
    {
        this.cell_state=cell_state;
    }
    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
