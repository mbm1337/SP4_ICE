import java.util.ArrayList;
import util.*;

public class Game {
    int weaponCountdown;
    ArrayList<String> leaderboard;
    TextUI ui;
    FileIO io;

    String name;

    Player p;
    Lane leftLane;
    Lane midLane;
    Lane rightLane;



    public void mainMenu(){
        ui = new TextUI();

        io = new FileIO();

        leaderboard = io.readLeaderBoardData("src/learderbord.csv");

        ui = new  TextUI();

        name = ui.getInput("Please enter your name");
        p = new Player(name);
        p.setCurrentLane(midLane);



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


    }

    public void displayLeaderboard() {


    }

    public void quitGame(){


    }


    public void drawCourse(){

        leftLane = new Lane(200);
        leftLane.draw();
        midLane = new Lane(400);
        midLane.draw();
        rightLane = new Lane(600);
        rightLane.draw();
    }

    public void moveRight() {
        if (p.getCurrentLane() == leftLane) {
            p.setCurrentLane(midLane);
            p.switchLane(rightLane,midLane,leftLane);
        } else if (p.getCurrentLane() == midLane) {
            p.setCurrentLane(rightLane);
            p.switchLane(rightLane,midLane,leftLane);
        } else {
            p.setCurrentLane(rightLane);
            p.switchLane(rightLane,midLane,leftLane);
        }

    }

    public void moveLeft() {
            if (p.getCurrentLane() == rightLane) {
                p.setCurrentLane(midLane);
                p.switchLane(rightLane,midLane,leftLane);
            } else if (p.getCurrentLane() == midLane) {
                p.setCurrentLane(leftLane);
                p.switchLane(rightLane,midLane,leftLane);
            } else {
                p.setCurrentLane(leftLane);
                p.switchLane(rightLane,midLane,leftLane);
            }
        }
}



