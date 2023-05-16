public class Projectiles {
    private int size;
    private int speed = 4;
    private int xPosition;
    private int yPosition;
    private int fireRate;

    Game game = new Game();

    public Projectiles(){

        yPosition = game.p.getYPosition();
        xPosition = game.p.getXPosition();

        
    }
    public void onImpact(){

    }

    public void draw(){
        Main.p.fill(0);
        Main.p.ellipse(xPosition,yPosition,5,5);
        yPosition = yPosition - speed;
    }
}
