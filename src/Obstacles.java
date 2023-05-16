public abstract class Obstacles {

    int numberOfObstacles;
    int xPosition;
    float speed;
    float yPosition;


    public float getYPosition() {
        return yPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public abstract void speedUp();
}