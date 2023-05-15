import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends PApplet {
    int width = 1000;
    int height = 800;
    public static PApplet p;

    Game game;
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
        game = new Game();
        game.mainMenu();

    }
    public void draw(){
        game.startGame();
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