public enum ShotResult {
    HIT,
    SUNK,
    MISS;

    private String ship;

    public void setSunkShip(String ship){
        this.ship = ship;
    }

    public String getSunkShip(){
        return this.ship;
    }
}
