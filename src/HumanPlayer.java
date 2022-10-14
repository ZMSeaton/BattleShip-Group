public class HumanPlayer implements IPlayer {

    protected String name;
    protected ShipPlacer ship_placer = new ShipPlacer();
    protected TargetGrid Targetgrid;
    protected OceanGrid ocean_Grid;

    public HumanPlayer(String name) {
        this.name = name;

    }

    public String get_name() {

        return name;
    }

    public Shot takeShot() {
    }

    public boolean allShipsAreSunk() {
        if (ocean_Grid.GetShips().isEmpty()) {

            return true;
        }

        return false;
    }

    public void PlaceShips() {
    }

    public ShotResult RecieveShot() {
    }

    public void RecieveShotResult() {
    }

}
