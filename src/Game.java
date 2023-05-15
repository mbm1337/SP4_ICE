import java.util.ArrayList;
import util.*;


public class Game {
    int weaponCountdown;
    int score;
    int xPosition;
    ArrayList<String> leaderboard;
    TextUI ui;
    FileIO io;
    String name;
    Player p;
    NonShootableObstacles obs1;
    ShootableObstacles obs2;
    Shotgun shotgun;
    Lane leftLane;
    Lane midLane;
    Lane rightLane;
    Obstacles obs;

    NonShootableObstacles obs3;


    public void mainMenu(){
        io = new FileIO();
        leaderboard = io.readLeaderBoardData("src/leaderboard.csv");

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
        score = 0;

        leftLane = new Lane(200);
        midLane = new Lane(400);
        rightLane = new Lane(600);
        p.setCurrentLane(midLane);
        obs1 = new NonShootableObstacles();
        obs2 = new ShootableObstacles();
        shotgun = new Shotgun();
        obs3 = new NonShootableObstacles();
    }

    public void startGame(){
        drawCourse();
        p.draw();
        obs1.draw();
        checkObsPosition(obs1);
        obs2.draw();
        checkObsPosition(obs2);
        shotgun.draw();
        pickUpWeapon(shotgun,40);

    }


    public void displayLeaderboard() {
        for (String s : leaderboard ) {
            ui.displayMessage(s);
        }

        if(ui.getInput("Press Q to get back").equalsIgnoreCase("Q")){
            mainMenu();
        }


    }

    public void quitGame(){
        io.saveLeaderBoardData("src/leaderboard.csv", leaderboard);
        System.exit(0);
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
        if (obs.equals(obs1)){
            obs1 = new NonShootableObstacles();
        }
        if (obs.equals(obs2)){
            obs2 = new ShootableObstacles();
        }
    }

    public void checkObsPosition(Obstacles obs){
        if(obs.getYPosition() >= 800){
            spawnNewObs(obs);
        }
    }

    public void pickUpWeapon(Shotgun weapon,int diff){
        if(weapon.getYPosition() == p.getYPosition() && weapon.getXPosition()-diff == p.getXPosition() ){
            weapon.setYPosition(p.getYPosition());
            weapon.setXPosition(p.getXPosition());
            weapon.setSpeed(0);
        }
    }

}



