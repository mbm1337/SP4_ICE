import processing.core.PApplet;

public class Main extends PApplet {
    int width = 1000;
    int height = 800;
    public static PApplet p;
    public static void main(String[] args) {
        PApplet.main("Main");

    }
    @Override
    public void settings() {
        size(width, height);
    }
    @Override
    public void setup(){
        p = this;
    }
    public void draw(){
        Player player = new Player();
        Lane lane = new Lane(200);
        Lane lane2 = new Lane(400);
        Lane lane3 = new Lane(600);
        lane.draw();
        player.draw();


    }
}