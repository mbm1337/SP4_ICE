import  java.lang.System;
import java.util.Random;

public class Score {
    int counter;
    boolean isRunning;
    int score;
    long s = System.currentTimeMillis();
    int duration = 1000;
    int timer = 0;

    Score() {
        counter = 0;
        isRunning = false;
        score = 0;
    }
// draw function to paint and keep checking if we have turned it on. we only want to start counting score the second we start the game. and some score and userfriendlyness.
    public void draw() {
        if (isRunning) {
            if ((int) System.currentTimeMillis() - timer > duration) {
                counter++;
                score = counter * 100;
                timer = (int) System.currentTimeMillis();
            }
            Main.p.fill(200,0,0);
            Main.p.textSize(20);
            Main.p.text("Press Esc to quit!",20,350);
            Main.p.textSize(45);
            Main.p.text("Score:",20,400);
            Main.p.text(score,20,450);
        }
    }
    //add score by adding to counter, not score. or else it would reset
    public void addScore(int score){this.counter += score/100;}
    public int getScore(){
        return score;
    }
    //simple start and off function
    public void setIsRunning(boolean tmpIsRunning){
        this.isRunning = tmpIsRunning;
    }
}
