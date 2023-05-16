public class Player {

    private int score;
    private boolean haveWeapon;
    private int width = 1000;
    private int height = 800;
    private int xPosition;
    private int yPosition;
    private Lane currentLane;
    private String name;

    public Player(String name){
        this.name = name;
        score = 0;
        xPosition = 450;
        yPosition = 750;


    }
    public void switchLane(Lane rightLane, Lane midLane, Lane leftLane){

        if(currentLane == rightLane){
            xPosition = 650;
        }else if (currentLane == midLane){
            xPosition = 450;
        }else if (currentLane == leftLane){
            xPosition = 250;
        }

    }
    public void onKill(){

    }
    public void onGemPickUp(){

    }

    public void draw(){

        Main.p.fill(150);
        Main.p.rect(xPosition,yPosition,100,40);
        Main.p.fill(100,70,50);
        Main.p.rect(xPosition+35,yPosition+10,30,20);
    }

    public Lane getCurrentLane() {
        return currentLane;
    }

    public void setCurrentLane(Lane currentLane) {
        this.currentLane = currentLane;
    }
    public int getXPosition(){
        return xPosition;
    }
    public int getYPosition(){
        return yPosition;
    }
    public int setXPosition(int xPosition){
        this.xPosition = xPosition;
        return xPosition;
    }
    public int setYPosition(int yPosition){
        this.yPosition = yPosition;
        return yPosition;
    }

}
