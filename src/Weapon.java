public abstract class Weapon {
    private int runTime;
    private int damage;
    private int xPosition;
    private float yPosition;
    private float speed;


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
    public float setYPosition(float yPosition){
        this.yPosition = yPosition;
        return yPosition;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
