import Weapon.*;
public class Lane {
    private int yPosition;
    private int width;
    private int height;
    private int xPosition;

    public Lane(int xPosition){
        this.yPosition = 0;
        this.xPosition = xPosition;
        this.width = 200;
        this.height = 800;

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
        Main.p.rect(600, 0, 200, 800);
        Main.p.rect(400, 0, 200, 800);
        Main.p.rect(200, 0, 200, 800);
    }
}
