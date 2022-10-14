public interface IPlayer {

    public String get_name();

    public void PlaceShips();

    public Shot takeShot();

    public boolean allShipsAreSunk();

    public ShotResult RecieveShot(Shot shot);

    public void RecieveShotResult(ShotResult shotResult);
}
