public class Player {

    private int score;
    private boolean haveWeapon;
    private int position;

    private Lane currentLane;

    String name;

    public Player(String name){
        this.name = name;
        score = 0;

    }
    public void pickUpWeapon(){

    }
    public void switchLaneRight(){

    }
    public void switchLaneLeft(){

    }
    public void onKill(){

    }
    public void onGemPickUp(){

    }
    public void onImpact(){

    }

    public Lane getCurrentLane() {
        return currentLane;
    }

    public void setCurrentLane(Lane currentLane) {
        this.currentLane = currentLane;
    }
}
