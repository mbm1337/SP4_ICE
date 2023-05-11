public class Player {

    private int score;
    private boolean haveWeapon;
    private int position;
    private int width = 1000;
    private int height = 800;
    private int xPosition;
    private int yPosition;

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
    public void draw(){
        xPosition = 450;
        yPosition = 750;
        Main.p.fill(150);
        Main.p.rect(xPosition,yPosition,100,40);
        Main.p.fill(100,70,50);
        Main.p.rect(xPosition+35,yPosition+10,30,20);

    }
    public void keyPressed(){

    }

    public Lane getCurrentLane() {
        return currentLane;
    }

    public void setCurrentLane(Lane currentLane) {
        this.currentLane = currentLane;
    }
}
