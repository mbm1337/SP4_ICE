import java.util.Random;
public class ShootableObstacles extends Obstacles {
    int health;
    int xPosition;
    int yPosition;
    //todo: lav speed hurtigere uden at den resetter;
    int speed = 2;
    Random random = new Random();

    public ShootableObstacles(int yPosition) {
        health = 10;
        this.yPosition = yPosition;

        int x = random.nextInt(3);
        switch (x) {
            case 0:
                xPosition = 300;
                break;
            case 1:
                xPosition = 500;
                break;
            case 2:
                xPosition = 700;
                break;
            default:
        }
    }

    public void onDeath(){
        if(health <= 0){
            //todo:    == null
            //todo: score += 10;
        }
    }
    public void draw(){
        Main.p.fill(0,0,255);
        Main.p.strokeWeight(3);
        Main.p.ellipse(xPosition,yPosition,100,100);
        Main.p.fill(30,60,10);
        Main.p.ellipse(xPosition,yPosition,30,30);
        yPosition = yPosition + speed;
        speed += 0.01;


    }
    public int getXPosition(){
        return xPosition;
    }
    public int getYPosition(){
        return yPosition;
    }
}
