public class Projectiles {
    private int speed;
    private int position;
    private int fireRate;
    private boolean isFiring;

    public Projectiles(int fireRate, int position){
        this.speed = 2;
        this.fireRate = fireRate;
        this.position = position;
        this.isFiring = false;
        //todo: this.speed = lav speed
        
    }

    public void onImpact(ShootableObstacles obstacles){

    }

    public boolean checkCollision(ShootableObstacles obstacles){
        if(position <= obstacles.xPosition){
            return true;
        }
        return false;
    }

}
