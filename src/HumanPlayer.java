public class HumanPlayer implements IPlayer {

    protected String name;
    protected ShipBuilder shipbuilder = new ShipBuilder();
    protected TargetGrid Targetgrid;
    protected OceanGrid ocean_Grid;

    public HumanPlayer(String name) {
        this.name = name;

    }

    public String get_name() {

        return name;
    }

    public Shot takeShot() {
        ocean_Grid.printGrid();
        Targetgrid.printGrid();

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
        return shot;

    }

    public boolean allShipsAreSunk() {
        if (ocean_Grid.getShips().isEmpty()) {

            return true;
        }

        return false;
    }

    public void PlaceShips() {

    }

    public ShotResult RecieveShot(Shot gotshot) {
        return ocean_Grid.getShotResult(gotshot);
    }

    public void RecieveShotResult(ShotResult shotResult) {

        System.out.printf("Your oponent's shot was a %s", shotResult.toString());

    }

}
