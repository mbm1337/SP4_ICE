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

    public String[][] readLeaderBoardData(String path) {
       // ArrayList<String> data = new ArrayList<>(20);
        String[][] namesScores = new String[20][2];
        int x = 0;
        try {
            file = new File(path);
            scan = new Scanner(file);
            scan.nextLine(); // ignore header in csv
            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                String[] s = line.split(":");
                namesScores[x][0] = s[0];
                namesScores[x][1] = s[1];
                x+=1;
               // data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }
        Comparator<String[]> scoreComparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                // Split the strings into name and score
                int score1 = Integer.parseInt(s1[1]);
                int score2 = Integer.parseInt(s2[1]);
                //compare scores and return unless the score is the same. then sort by name.
                if (score1 == score2) {
                    return s1[0].compareTo(s2[0]);
                }
                //compare scores and return them.
                return Integer.compare(score2, score1);
            }
        };

        Arrays.sort(namesScores, scoreComparator);
        return namesScores;
    }
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
