import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet p;

    Game game;
    public static void main(String[] args) {
        PApplet.main("Main");

    }
    @Override
    public void settings() {
        int height = 800;
        int width = 1000;
        size(width, height);
    }
    @Override
    public void setup(){
        p = this;
        game = new Game();
        game.mainMenu();

    }
    public void draw(){
        game.gameLoop();
    }

    public void keyPressed(){
        if(key == 'a' || key == 'A'){
            game.moveLeft();
        }
        if(key == 'd' || key == 'D'){
            game.moveRight();
        }
        if(keyCode == 27){
            game.quitGame();
        }
    }
}