
public class Lane {

    private int xPosition;

    public Lane(int xPosition){
        this.xPosition = xPosition;

    }

    public void draw() {
        Main.p.strokeWeight(5);
        Main.p.fill(0,200,200,150);
        Main.p.rect(xPosition, 0, 200, 800);
        Main.p.rect(xPosition, 0, 200, 800);
        Main.p.rect(xPosition, 0, 200, 800);

    }
}
