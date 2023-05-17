public abstract class Weapon {

    private int xPosition;
    private int yPosition;
    private int speed;


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
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
