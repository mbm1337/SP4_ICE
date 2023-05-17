public class Projectiles {
    private int size;
    private int speed = 4;
    private int xPosition;
    private int yPosition;
    private int fireRate = 1;

    public Projectiles(Player p){
        yPosition = p.getYPosition();
        xPosition = p.getXPosition();
        
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void draw(){
        Main.p.fill(0);
        Main.p.ellipse(xPosition, yPosition, 5, 5);
        yPosition = yPosition - speed;


    }

}
