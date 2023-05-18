import java.util.Random;
public class Shotgun extends Weapon {

   private int xPosition;
   private float yPosition;
   private float speed;
   Random random = new Random();


   public Shotgun(){
       yPosition = -550;
       this.speed = 2;

       int x = random.nextInt(3);
       switch (x) {
           case 0 -> xPosition = 290;
           case 1 -> xPosition = 490;
           case 2 -> xPosition = 690;
           default -> {
           }
       }
   }

    public void draw(){
       Main.p.fill(50);
       Main.p.strokeWeight(1);
       Main.p.rect(xPosition,yPosition,20,40);
       Main.p.textSize(10);
       Main.p.fill(255,0,0);
       Main.p.text("Shotgun",xPosition-7,yPosition-4);
       yPosition = yPosition + speed;

    }
    public void setSpeed(float speed){
       this.speed = speed;
    }
    public int getXPosition(){
        return xPosition;
    }
    public void speedUp() {
        this.speed = (float) (this.speed + 0.1);
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
}
