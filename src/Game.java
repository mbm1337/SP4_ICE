import util.*;
import java.util.Arrays;


public class Game {
    private int weaponCountdown;
    private String[][] leaderboard;
    private TextUI ui;
    private FileIO io;
    private String name;
    public Player p;
    private Lane leftLane;
    private Lane midLane;
    private Lane rightLane;
    private NonShootableObstacles nonShootObs1;
    private NonShootableObstacles nonShootObs2;
    private NonShootableObstacles nonShootObs3;
    private ShootableObstacles shootObs;
    private Shotgun shotgun;
    private Score score;
    private boolean weaponPickedUp;
    private Projectiles[] p1;
    private int timeInterval;

    public void mainMenu(){
        io = new FileIO();
        leaderboard = io.readLeaderBoardData("src/leaderboard.csv");
        score = new Score();
        ui = new TextUI();
        String input = ui.getInput("Please choose:" +
                "\n 1. Start Game" +
                "\n 2. Display Leaderboard" +
                "\n 3. Quit Game");
        switch (input){
            case "1":
                setupGame();
                Main.p.draw();
                break;
            case "2":
                displayLeaderboard();
                break;
            case "3":
                quitGame();
                break;
            default:
                ui.displayMessage("This is not a option");
                mainMenu();
        }
    }

    public void setupGame() {
        name = ui.getInput("Please enter your name");
        ui.displayMessage("The game is on!");
        p = new Player(name);
        leftLane = new Lane(200);
        midLane = new Lane(400);
        rightLane = new Lane(600);
        p.setCurrentLane(midLane);
        nonShootObs1 = new NonShootableObstacles(0);
        nonShootObs2 = new NonShootableObstacles(-200);
        nonShootObs3 = new NonShootableObstacles(-400);
        shootObs = new ShootableObstacles(-600);
        shotgun = new Shotgun();

        p1 = new Projectiles[16];
        for(int i = 0; i < p1.length; i++) {
            p1[i] = new Projectiles(p);
        }

    }

    public void startGame(){
        Main.p.background(255);
        score.setIsRunning(true);
        score.draw();
        drawCourse();
        p.draw();
        nonShootObs1.draw();
        checkObsPosition(nonShootObs1);
        nonShootObs2.draw();
        checkObsPosition(nonShootObs2);
        nonShootObs3.draw();
        checkObsPosition(nonShootObs3);
        shootObs.draw();
        checkObsPosition(shootObs);
        speedUp();
        shotgun.draw();
        pickUpWeapon(shotgun, 40);

        if(weaponPickedUp){
            fixedWeapon(shotgun);
            for (int i = 0; i < p1.length; i++) {
                    p1[i].draw();
            }
            updateProjectiles();
        }
        removeWeapon(shotgun);
        checkWeaponPosition(shotgun);
        onImpact();
        onDeath();

    }

    public void displayLeaderboard() {
        for (String[] s : leaderboard ) {
            ui.displayMessage(s[0] + " - " +s[1]);
        }
        if(ui.getInput("Press Q to get back").equalsIgnoreCase("Q")){
            mainMenu();
        }
    }

    public void quitGame(){
        score.setIsRunning(false);
        saveScoreToLeaderboard();
        io.saveLeaderBoardData("src/leaderboard.csv", leaderboard);
        System.exit(0);
    }

    private void saveScoreToLeaderboard() {
        String[] newPlayer = {name, String.valueOf(score.getScore())};
        String[][] updatedLeaderboard = new String[leaderboard.length + 1][2];
        int index = 0;
        for (int i = 0; i < leaderboard.length; i++) {
            if (Integer.parseInt(leaderboard[i][1]) < score.getScore()) {
                break;
            }
            index++;
        }
        if (index == leaderboard.length) {
            updatedLeaderboard = Arrays.copyOf(leaderboard, leaderboard.length + 1);
            updatedLeaderboard[leaderboard.length] = newPlayer;
        } else {
            System.arraycopy(leaderboard, 0, updatedLeaderboard, 0, index);

            // Insert the new player at the insertion index
            updatedLeaderboard[index] = newPlayer;

            // Copy remaining elements after the insertion index
            System.arraycopy(leaderboard, index, updatedLeaderboard, index + 1, leaderboard.length - index-1);
        }
        leaderboard = updatedLeaderboard;
        leaderboard = Arrays.copyOf(leaderboard, leaderboard.length-1);
    }

    public void drawCourse(){
        leftLane.draw();
        midLane.draw();
        rightLane.draw();
    }

    public void moveRight() {
        if (p.getCurrentLane().equals(midLane)) {
            p.setCurrentLane(rightLane);
            p.switchLane(rightLane,midLane,leftLane);
        } else if (p.getCurrentLane().equals(leftLane)) {
            p.setCurrentLane(midLane);
            p.switchLane(rightLane,midLane,leftLane);
        } else {
            p.setCurrentLane(rightLane);
            p.switchLane(rightLane,midLane,leftLane);
        }
    }

    public void moveLeft() {
            if (p.getCurrentLane().equals(midLane)) {
                p.setCurrentLane(leftLane);
                p.switchLane(rightLane,midLane,leftLane);
            } else if (p.getCurrentLane().equals(rightLane)) {
                p.setCurrentLane(midLane);
                p.switchLane(rightLane,midLane,leftLane);
            } else {
                p.setCurrentLane(leftLane);
                p.switchLane(rightLane,midLane,leftLane);
            }
    }

    public void spawnNewObs(Obstacles obs){
        if (obs.equals(nonShootObs1)){
            nonShootObs1.randomLaneSelector();
            nonShootObs1.setYPosition(-10);
        }
        if (obs.equals(nonShootObs2)){
            nonShootObs2.randomLaneSelector();
            nonShootObs2.setYPosition(-10);
        }
        if (obs.equals(nonShootObs3)){
            nonShootObs3.randomLaneSelector();
            nonShootObs3.setYPosition(-10);
        }
        if (obs.equals(shootObs)){
            shootObs.randomLaneSelector();
            shootObs.setYPosition(-10);
        }
    }

    public void checkObsPosition(Obstacles obs){
        if(obs.getYPosition() >= 800){
            spawnNewObs(obs);
        }
    }

    public void pickUpWeapon(Weapon weapon,int diff){
        if(weapon.getYPosition() == p.getYPosition() && weapon.getXPosition()-diff == p.getXPosition()) {
            weapon.setXPosition(p.getXPosition());
            weapon.setYPosition(p.getYPosition());
            weapon.setSpeed(0);
            weaponPickedUp = true;
            weaponCountdown = 550;
        }
    }

    public void fixedWeapon(Weapon weapon){
        weapon.setYPosition(p.getYPosition());
        weapon.setXPosition(p.getXPosition());
        weapon.setSpeed(0);
        weaponCountdown -= 1;
    }

    public void removeWeapon(Weapon weapon){
        if(weaponCountdown == 0){
            weaponPickedUp = false;
            weapon.setSpeed(2);
        }
    }

    public void checkWeaponPosition(Weapon weapon){
        if(weapon.getYPosition() >= 900){
            spawnNewWeapon(weapon);
        }
    }

    public void spawnNewWeapon(Weapon weapon){
        if(weapon.equals(shotgun)){
            shotgun = new Shotgun();
        }
    }

    public void speedUp(){
        if(shootObs.getSpeed()<10) {
            if (Main.p.frameCount % 100 == 0) {
                nonShootObs3.speedUp();
                nonShootObs2.speedUp();
                nonShootObs1.speedUp();
                shootObs.speedUp();
            }
        }
    }

    public boolean onImpact(){
        int nonShootObsHeight = 60;
        int shootObsRadius = 50;
        if(        (int)nonShootObs1.getYPosition()+nonShootObsHeight >= p.getYPosition()
                && (int)nonShootObs1.getYPosition() <= p.getYPosition()
                && nonShootObs1.getXPosition()+25 == p.getXPosition()
                || (int)nonShootObs1.getYPosition()+nonShootObsHeight >= p.getYPosition()+40
                && (int)nonShootObs1.getYPosition() <= p.getYPosition()+40
                && nonShootObs1.getXPosition()+25 == p.getXPosition()) {
            return true;
        }
        else if(   (int)nonShootObs2.getYPosition()+nonShootObsHeight >= p.getYPosition()
                && (int)nonShootObs2.getYPosition() <= p.getYPosition()
                && nonShootObs2.getXPosition()+25 == p.getXPosition()
                || (int)nonShootObs2.getYPosition()+nonShootObsHeight >= p.getYPosition()+40
                && (int)nonShootObs2.getYPosition() <= p.getYPosition()+40
                && nonShootObs2.getXPosition()+25 == p.getXPosition()){
            return true;
        }
        else if(   (int)nonShootObs3.getYPosition()+nonShootObsHeight >= p.getYPosition()
                && (int)nonShootObs3.getYPosition() <= p.getYPosition()
                && nonShootObs3.getXPosition()+25 == p.getXPosition()
                || (int)nonShootObs3.getYPosition()+nonShootObsHeight >= p.getYPosition()+40
                && (int)nonShootObs3.getYPosition() <= p.getYPosition()+40
                && nonShootObs3.getXPosition()+25 == p.getXPosition()){
            return true;
        }
        else if (  (int)shootObs.getYPosition()+shootObsRadius >= p.getYPosition()
                && (int)shootObs.getYPosition()-shootObsRadius <= p.getYPosition()
                && shootObs.getXPosition()-shootObsRadius == p.getXPosition()
                || (int)shootObs.getYPosition()+shootObsRadius >= p.getYPosition() + 40
                && (int)shootObs.getYPosition()-shootObsRadius <= p.getYPosition() + 40
                && shootObs.getXPosition()-shootObsRadius == p.getXPosition()) {
            return true;

        } else
        return false;
    }
    public void onDeath(){
        if (onImpact()){
            Main.p.noLoop();
        }
    }
    public void updateProjectiles() {

        if (Main.p.frameCount % 30 == 0) {
            for (int i = 0; i < p1.length; i++) {
                if (p1[i].getYPosition() < 0) {
                    p1[i].setXPosition(p.getXPosition());
                    p1[i].setYPosition(p.getYPosition());
                    break;
                }
            }
        }
        for (int i = 0; i < p1.length; i++) {
            if (p1[i].getYPosition() >= 0) {
                p1[i].draw();
            }
        }
    }
}