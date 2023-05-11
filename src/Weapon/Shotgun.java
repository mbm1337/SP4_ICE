package Weapon;

public class Shotgun extends Weapon{

   private int runTime;
   private int damage;
   private int position;

   public Shotgun(){
       this.runTime = 10;
       this.damage = 5;
       //todo: this.position = randomized på de 3 lanes.
   }

    @Override
    public void shoot() {

    }
}
