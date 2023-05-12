import java.util.ArrayList;

import Weapon.*;
import util.*;

public class Game {
    int weaponCountdown;

    int score;
    ArrayList<String> leaderboard;
    TextUI ui;
    FileIO io;
    String name;
    Player p;
    NonShootableObstacles obs1;
    Lane leftLane;
    Lane midLane;
    Lane rightLane;






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

    public void startGame(){
        drawCourse();
        p.draw();
        obs1.draw();
        runGameLoop();
    }

    public void setupGame() {
        name = ui.getInput("Please enter your name");
        p = new Player(name);
        score = 0;

        leftLane = new Lane(200);
        midLane = new Lane(400);
        rightLane = new Lane(600);
        p.setCurrentLane(midLane);

        obs1 = new NonShootableObstacles();

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


    public void runGameLoop() {


    }




}



