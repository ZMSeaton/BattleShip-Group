public class HumanPlayer implements IPlayer {

    protected String name;
    protected ShipBuilder shipBuilder = new ShipBuilder();
    protected TargetGrid targetGrid;
    protected OceanGrid oceanGrid;

    public HumanPlayer(String name) {
        this.name = name;
        oceanGrid = new OceanGrid(null);
        targetGrid = new TargetGrid();

    }

    public String get_name() {

        return name;
    }

    public Shot takeShot() {
        oceanGrid.printGrid();
        targetGrid.printGrid();

        String humancoordinate = ConsoleHelper.getInput("Type where you want to shoot.");

        Shot shot;
        while (true) {

            try {

                shot = new Shot(humancoordinate);
                break;
            } catch (Exception exception) {
                System.out.println("Those coordinates don't work.");
                continue;
            }
        }
        while (true) {
            if (targetGrid.isShotValid(shot.getRow(), shot.getColumn())==true) {
                System.out.println("Those coordinates have already been shot at.");
                continue;

            } else {
                break;
            }
        }
        return shot;

    }

    public boolean allShipsAreSunk() {
        if (oceanGrid.getShips().isEmpty()) {

            return true;
        }

        return false;
    }

    public void PlaceShips() {
        shipBuilder.buildShips(oceanGrid.getShips());

    }

    public ShotResult RecieveShot(Shot gotshot) {
        return oceanGrid.getShotResult(gotshot);
    }

    public void RecieveShotResult(ShotResult shotResult) {

        System.out.printf("Your oponent's shot was a %s", shotResult.toString());

    }

}
