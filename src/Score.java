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

    public void draw() {
        if (isRunning) {
            if ((int) System.currentTimeMillis() - timer > duration) {
                counter++;
                score = counter * 100;
                System.out.println(score);
                timer = (int) System.currentTimeMillis();
            }
            Main.p.clear();
            Main.p.fill(200,0,0);
            Main.p.textSize(45);
            Main.p.text("Score:",20,400);
            Main.p.text(score,20,450);
        }
    }
    public void addScore(int score){this.score += score;}
    public int getScore(){
        return score;
    }
    public boolean getisRunning(){
        return isRunning;
    }
    public void setIsRunning(boolean tmpIsRunning){
        this.isRunning = tmpIsRunning;
    }
}
