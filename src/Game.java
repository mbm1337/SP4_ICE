import java.util.ArrayList;
import java.util.Arrays;

import util.*;


public class Game {
    int weaponCountdown;
    int xPosition;
    String[][] leaderboard;
    TextUI ui;
    FileIO io;
    String name;
    Player p;
    Lane leftLane;
    Lane midLane;
    Lane rightLane;
    NonShootableObstacles nonShootObs1;
    NonShootableObstacles nonShootObs2;

    NonShootableObstacles nonShootObs3;

    ShootableObstacles shootObs;
    Shotgun shotgun;
    Score score;

    private boolean weaponPickedUp;


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

    }

    public void startGame(){
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


        shotgun.draw();
        pickUpWeapon(shotgun, 40);
        if(weaponPickedUp){
            fixedWeapon(shotgun);
        }
        removeWeapon(shotgun);
        checkWeaponPosition(shotgun);


    }

    public void displayLeaderboard() {
        for (String[] s : leaderboard ) {
            ui.displayMessage(s[0] + " = " +s[1]);
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
        int index = -1;
        for (int i = 0; i < leaderboard.length; i++) {
            if (leaderboard[i][1] != null && Integer.parseInt(leaderboard[i][1]) < score.getScore()) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = leaderboard.length - 1; i > index; i--) {
                leaderboard[i] = leaderboard[i - 1];
            }
        }

        leaderboard[index][0] = name;
        leaderboard[index][1] = String.valueOf(score.getScore());

        if (leaderboard.length > 20) {
            leaderboard = Arrays.copyOf(leaderboard, 20);
        }
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
            nonShootObs1 = new NonShootableObstacles(-10);
        }
        if (obs.equals(nonShootObs2)){
            nonShootObs2 = new NonShootableObstacles(-10);
        }
        if (obs.equals(nonShootObs3)){
            nonShootObs3 = new NonShootableObstacles(-10);
        }
        if (obs.equals(shootObs)){
            shootObs = new ShootableObstacles(-10);
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
            weaponCountdown = 500;

        }
    }
    public void fixedWeapon(Weapon weapon){
        weapon.setYPosition(p.getYPosition());
        weapon.setXPosition(p.getXPosition());
        weapon.setSpeed(0);
        weaponCountdown -= 1;
    }
    public void removeWeapon(Weapon weapon){
        System.out.println(weaponCountdown);
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

    public void displayScore(int score){
        Main.p.text(score,450,450);
    }
}



