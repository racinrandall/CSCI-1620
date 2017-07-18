package project1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Echo {

    public static void copyFile(String fileName) {
        int ch;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            while ((ch = input.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException exception) {
            System.err.println("unable to process" + fileName);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            copyFile(args[i]);
        }
    }
}