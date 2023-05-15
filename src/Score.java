public class Score {
    int counter;
    boolean isRunning;
    int score;

    Score() {
        counter = 0;
        isRunning = false;
    }

    public void draw() {
        while (isRunning) {
            counter++;
            score = counter * 100;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
