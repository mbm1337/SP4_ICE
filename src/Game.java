import java.util.ArrayList;
import util.*;

public class Game {
    int weaponCountdown;
    ArrayList<String> leaderboard;
    TextUI ui;
    FileIO io;

    String name;

    Player p;
    NonShootableObstacles obs1;
    ShootableObstacles obs2;
    Lane leftLane;
    Lane midLane;
    Lane rightLane;



    public void mainMenu(){
        ui = new TextUI();
        io = new FileIO();
        leaderboard = io.readLeaderBoardData("src/learderbord.csv");

        leftLane = new Lane(200);
        midLane = new Lane(400);
        rightLane = new Lane(600);

        name = ui.getInput("Please enter your name");
        p = new Player(name);
        p.setCurrentLane(midLane);
        obs1 = new NonShootableObstacles();
        obs2 = new ShootableObstacles();



        String input = ui.getInput("Please choose:");

        switch (input){
            case "1":
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
        obs2.draw();

    }

    public void displayLeaderboard() {


    }

    public void quitGame(){


    }


    public void drawCourse(){
        leftLane.draw();
        midLane.draw();
        rightLane.draw();
    }

    public void moveRight() {
        if (p.getCurrentLane().equals(leftLane)) {
            p.setCurrentLane(midLane);
            p.switchLane(rightLane,midLane,leftLane);
        } else if (p.getCurrentLane().equals(midLane)) {
            p.setCurrentLane(rightLane);
            p.switchLane(rightLane,midLane,leftLane);
        } else {
            p.setCurrentLane(rightLane);
            p.switchLane(rightLane,midLane,leftLane);
        }

    }

    public void moveLeft() {
            if (p.getCurrentLane().equals(rightLane)) {
                p.setCurrentLane(midLane);
                p.switchLane(rightLane,midLane,leftLane);
            } else if (p.getCurrentLane().equals(midLane)) {
                p.setCurrentLane(leftLane);
                p.switchLane(rightLane,midLane,leftLane);
            } else {
                p.setCurrentLane(leftLane);
                p.switchLane(rightLane,midLane,leftLane);
            }
        }
}



