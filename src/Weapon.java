public abstract class Weapon {

    private int xPosition;
    private float yPosition;
    private float speed;


    public int getXPosition(){
        return xPosition;
    }
    public float getYPosition(){
        return yPosition;
    }
    public int setXPosition(int xPosition){
        this.xPosition = xPosition;
        return xPosition;
    }
    public float setYPosition(float yPosition){
        this.yPosition = yPosition;
        return yPosition;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
