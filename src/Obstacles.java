public abstract class Obstacles {

    int xPosition;
    float yPosition;


    public float getYPosition() {
        return yPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public abstract void speedUp();
}