package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FileIO {
    File file;
    Scanner scan;

    public ArrayList<String> readLeaderBoardData(String path) {
        ArrayList<String> data = new ArrayList<>(21);

        try {
            file = new File(path);
            scan = new Scanner(file);
            scan.nextLine(); // ignore header in csv
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }
        Comparator<String> scoreComparator = (s1, s2) -> {
            // Split the strings into name and score
            String[] s1Parts = s1.split(":");
            String[] s2Parts = s2.split(":");
            int score1 = Integer.parseInt(s1Parts[1]);
            int score2 = Integer.parseInt(s2Parts[1]);
            // Compare the scores
            return Integer.compare(score2, score1);
        };
        Collections.sort(data, scoreComparator);
        return data;
    }

    public void saveLeaderBoardData(String path, ArrayList<String> data){
        try {
            FileWriter file = new FileWriter(path);
            file.write("Name:Score\n");
            for(String s : data) {
                file.write(s+"\n");
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
