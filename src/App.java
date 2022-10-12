public class App {
    public static void main(String[] args) throws Exception {
        OceanGrid oceanGrid = new OceanGrid(new Ship[] {new Ship("TestShip", 3)});
        oceanGrid.printGrid();
    }
}
