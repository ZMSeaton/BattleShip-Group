public class HumanPlayer implements IPlayer {

    protected String name;
    protected ShipBuilder shipBuilder = new ShipBuilder();
    protected TargetGrid targetGrid;
    protected OceanGrid oceanGrid;

    public HumanPlayer(String name) {
        this.name = name;
        oceanGrid = new OceanGrid(shipBuilder.getShips());
        targetGrid = new TargetGrid();
    }

    public String getName() {
        return name;
    }

    private void printGrids(){
        targetGrid.printGrid();
        oceanGrid.printGrid();
    }

    public Shot takeShot() {//prints grids and asks for shot from player

        String humancoordinate;

        Shot shot;

        while (true) {
            printGrids();

            humancoordinate = ConsoleHelper.getInput("Type where you want to shoot.");

            try {
                shot = new Shot(humancoordinate);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            if (targetGrid.isShotValid(shot.getRow(), shot.getColumn())) {
                return shot;
            } else {
                System.out.println("Those coordinates have already been shot at.");
                continue;
            }
        }

    }

    public boolean allShipsAreSunk() {
        if (oceanGrid.isAllShipsSunk()) {
            return true;
        }
        return false;
    }

    public ShotResult recieveShot(Shot gotshot) {
        return oceanGrid.getShotResult(gotshot);
    }

    public void recieveShotResult(ShotResult shotResult, Shot shot) {
        targetGrid.updateTargetGrid(shot, shotResult);
    }

}
