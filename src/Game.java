import java.util.ArrayList;
import util.*;

public class Game {
    int weaponCountdown;
    ArrayList<String> leaderboard;
    TextUI ui;
    FileIO io;


    public void mainMenu(){
        ui = new TextUI();

        io = new FileIO();

        leaderboard = io.readLeaderBoardData("src/learderbord.csv");

        String input = ui.getInput("Please choose:");

        switch (input){
            case "1":
                startGame();
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
        ui = new TextUI();

        String name = ui.getInput("Please enter your name");

        Player p = new Player(name);

        Lane rigthLane = new Lane();
        Lane midLane = new Lane();
        Lane leftLane = new Lane();

        Course course = new Course(rigthLane,midLane,leftLane);

        p.setCurrentLane(midLane);





    }

    public void displayLeaderboard() {


    }

    public void quitGame(){


    }







}



