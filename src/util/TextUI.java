package util;

import java.util.Scanner;

public class TextUI {
    Scanner scan;

    public TextUI() {
        this.scan = new Scanner(System.in);
    }

    public String getInput(String msg) {
        displayMessage(msg);
        return scan.nextLine();
    }
    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
