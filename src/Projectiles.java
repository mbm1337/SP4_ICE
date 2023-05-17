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
    public void draw(){
        Main.p.fill(0);
        Main.p.ellipse(xPosition, yPosition, 5, 5);
        yPosition = yPosition - speed;


    }
    public int getxPosition(){

    }
}
