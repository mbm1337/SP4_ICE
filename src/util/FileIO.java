package util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {
    File file;
    Scanner scan;

    public ArrayList<String> readLeaderBoardData(String path) {
        ArrayList<String> data = new ArrayList<>(21);

        try {
            scan = new Scanner(file);
            scan.nextLine(); // ignore header in csv
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        }
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
