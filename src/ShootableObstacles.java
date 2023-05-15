import java.util.Random;
public class ShootableObstacles extends Obstacles {
    int health;
    int xPosition;
    float yPosition;
    float speed = 2;
    Random random = new Random();

    public ShootableObstacles() {
        health = 10;
        yPosition = -60;
        speed += 0.1;
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

    }
    public int getXPosition(){
        return xPosition;
    }
    public float getYPosition(){
        return yPosition;
    }
}
