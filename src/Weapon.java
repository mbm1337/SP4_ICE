public abstract class Weapon {
    private int runTime;
    private int damage;
    private int xPosition;
    private int yPosition;
    private int speed;


    public abstract void shoot();

    public abstract void removeWeapon();

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
    public int setYPosition(int yPosition){
        this.yPosition = yPosition;
        return yPosition;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
