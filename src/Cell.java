public final class Cell {
    private CellState cellState;
    private Ship ship;

    public CellState getState() {
        return cellState;
    }

    public void setState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip() {

        return ship;

    }
}
