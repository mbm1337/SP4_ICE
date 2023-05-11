package Weapon;

import Weapon.Weapon;

public class Rifle extends Weapon {

    private int runTime = 0;
    private int damage = 0;
    private int position;

    public Rifle(){
        this.runTime = 10;
        this.damage = 3;
        //todo: this.position = randomized på de 3 lanes.
    }

    @Override
    public void shoot() {

    }
}
