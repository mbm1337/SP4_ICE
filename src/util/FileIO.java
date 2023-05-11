package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    File file;
    Scanner scan;

    public ArrayList<String> readLeaderBoardData(String path) {

        file = new File(path);
        ArrayList<String> data = new ArrayList<>();


        try {
            scan = new Scanner(file);

            //scan.nextLine(); // ignore header in csv

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }
        return data;
    }

    void saveLeaderBoardData(String path, ArrayList<String> data){

    }

}
