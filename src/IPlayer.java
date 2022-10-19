public interface IPlayer {

    public String getName();

    public Shot takeShot();

    public boolean allShipsAreSunk();

    public ShotResult recieveShot(Shot shot);

    public void recieveShotResult(ShotResult shotResult, Shot shot);
}
