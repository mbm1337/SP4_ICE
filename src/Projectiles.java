public class Projectiles {
    private int speed = 4;
    private int xPosition;
    private float yPosition;

    public Projectiles(Weapon weapon){
        yPosition = weapon.getYPosition();
        xPosition = weapon.getXPosition();
        
    }
    public void draw(){
        Main.p.fill(0);
        Main.p.ellipse(xPosition, yPosition, 5, 5);
        yPosition = yPosition - speed;


    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

}
