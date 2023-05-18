package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class FileIO {
    File file;
    Scanner scan;
    //read from leaderboard.csv file and load them up into 2d double array.
    public String[][] readLeaderBoardData(String path) {
        String[][] namesScores = new String[20][2];
        int x = 0;
        try {
            file = new File(path);
            scan = new Scanner(file);
            scan.nextLine(); // ignore header
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if(!line.startsWith("null:null")) {
                    String[] s = line.split(":");
                    namesScores[x][0] = s[0];
                    namesScores[x][1] = s[1];
                    x += 1;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }
        //Sort the array. by score. in reverse natural order.
        Arrays.sort(namesScores, Comparator.comparingInt(arr -> -1 * Integer.parseInt(arr[1])));
        return namesScores;

    }
    //save the leaderboard to leaderboard.csv.
    public void saveLeaderBoardData(String path, String[][] data){
        try {
            FileWriter file = new FileWriter(path);
            file.write("Name:Score\n");
            for(String[] s : data) {
                file.write(s[0]+":"+s[1]+"\n");
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
