package Weapon;

public class Revolver extends Weapon{
    private int runTime;
    private int damage;
    private int position;

    public Revolver(){
        this.runTime = 10;
        this.damage = 3;
        //todo: this.position = randomized på de 3 lanes.
    }
    @Override
    public void shoot() {

    }
}
