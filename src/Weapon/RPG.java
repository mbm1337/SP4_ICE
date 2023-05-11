package Weapon;

public class RPG extends Weapon{
    private int runTime;
    private int damage;
    private int position;

    public RPG(){
        this.runTime = 10;
        this.damage = 10;
        //todo: this.position = randomized på de 3 lanes.
    }


    @Override
    public void shoot() {

    }
}
