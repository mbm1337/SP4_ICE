public abstract class Obstacles {
    int x, y, z;
    float speed = 4;
    int fixedX=300;
    int fixedY=250;
    boolean isDouble;
    boolean isTriple;


    Obstacles() {

    }

    void increaseSpeed(float tmp1) {
        this.speed = tmp1;

    }

    void move() {
        // Move obstacles
        x -= speed;
        y -= speed;
        z -= speed;
        // Draw sky
        Main.p.fill(0);
        Main.p.triangle(x, fixedX, y, fixedY, z, fixedX);
        if(isDouble){
            Main.p.triangle(x+25, fixedX, y+25, fixedY, z+25, fixedX);
        }
        if(isTriple){
            Main.p.triangle(x+50, fixedX, y+50, fixedY, z+50, fixedX);
        }
    }
    void reset() {
        // Reset sky position
        x = 800;
        y = 825;
        z = 850;
    }

    int numberOfObstacles;
    int position;

}
