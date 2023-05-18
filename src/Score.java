import  java.lang.System;

public class Score {
    private int counter;
    private boolean isRunning;
    private int score;
    private long s = System.currentTimeMillis();
    private int duration = 1000;
    private int timer = 0;


    public Score() {
        counter = 0;
        isRunning = false;
        score = 0;
    }

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
    public void addScore(int score){this.counter += score/100;}
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
