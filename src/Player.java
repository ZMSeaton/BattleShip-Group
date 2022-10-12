public class Player {
    private String name;
    private ShipPlacer ship_placer = new ShipPlacer();
    private TargetGrid Targetgrid;
    private OceanGrid ocean_Grid;

    public Player(String name) {
        this.name = name;

    }

    public String get_name() {

        return name;
    }

}