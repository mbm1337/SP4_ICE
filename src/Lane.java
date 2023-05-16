import processing.core.PApplet;

public class Lane {

    private int xPosition;

    public Lane(int xPosition){
        this.xPosition = xPosition;

    }
    Weapon weapon;

    Obstacles obstacles;

    Gem gem;

    public void spawnWeapon() {

    }

    public void spawnGem() {

    }

    public void spawnObstacle() {

    }

    public void draw() {
        Main.p.strokeWeight(5);
        Main.p.fill(0,200,200,150);
        Main.p.rect(xPosition, 0, 200, 800);
        Main.p.rect(xPosition, 0, 200, 800);
        Main.p.rect(xPosition, 0, 200, 800);

    }
}
