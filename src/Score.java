import  java.lang.System;

public class Score {
    int counter;
    boolean isRunning;
    int score;
    long s = System.currentTimeMillis();

    Score() {
        counter = 0;
        isRunning = false;
        score = 0;
    }

    public void draw() {
        /*if(isRunning) {
            counter++;
            score = counter * 100;
            System.out.println(score);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } */
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
