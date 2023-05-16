import java.util.Random;

public class NonShootableObstacles extends Obstacles {

    int numberOfObstacles;
    int xPosition;
    float yPosition;
    float speed;
    Random random = new Random();



    public NonShootableObstacles(int yPosition){
        this.yPosition = yPosition ;
        this.speed = 2;
        randomLaneSelector();

    }
    public void draw(){
        Main.p.fill(255,0,0);
        Main.p.strokeWeight(3);
        Main.p.rect(xPosition,yPosition,150,60);
        Main.p.textSize(45);
        Main.p.fill(0);
        Main.p.text("Danger",xPosition+5,yPosition+40);
        yPosition = yPosition+speed;

    }

    @Override
    public void speedUp() {
            this.speed = (float) (this.speed + 0.1);
    }

    public void setYPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public void randomLaneSelector(){
        int x = random.nextInt(3);
        switch (x) {
            case 0:
                xPosition = 225;
                break;
            case 1:
                xPosition = 425;
                break;
            case 2:
                xPosition = 625;
                break;
            default:
        }

    }
    public int getXPosition(){
        return xPosition;
    }
    public float getYPosition(){
        return yPosition;
    }
}
