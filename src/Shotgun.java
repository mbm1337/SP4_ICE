import java.util.Random;
public class Shotgun extends Weapon {

   private int xPosition;
   private int yPosition;
    //todo: lav speed hurtigere uden at den resetter;
   private int speed = 4;
   Random random = new Random();


   public Shotgun(){
       yPosition = -1000;

       int x = random.nextInt(3);
       switch (x) {
           case 0 -> xPosition = 290;
           case 1 -> xPosition = 490;
           case 2 -> xPosition = 690;
           default -> {
           }
       }
   }

    @Override
    public void shoot() {

    }

    @Override
    public void removeWeapon() {
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
    public void setSpeed(int speed){
       this.speed = speed;
    }
    public int getXPosition(){
        return xPosition;
    }
    public int getYPosition(){
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
