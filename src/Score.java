import  java.lang.System;

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
        }
        Main.p.text(score,450,450);
    }

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
