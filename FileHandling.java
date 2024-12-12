package com.example.oopproject;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandling {


    static final String FILE_PATH = "F:/CUI LAHORE/3rd Semester/OOP/OOPproject/src/main/java/com/example/oopproject/Calculations.txt";

    // Method to write expression to the file
    static public void writeFile(String expression) {
        File filePath = new File(FILE_PATH);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(expression + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read file content into an ArrayList
    static public ArrayList<String> readFile() {
        ArrayList<String> expressionsArray = new ArrayList<>();
        try (FileReader fr = new FileReader(FILE_PATH);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                expressionsArray.add(line);
            }

        } catch (IOException e) {
            expressionsArray.add("THERE IS NO HISTORY.");
        }
        return expressionsArray;
    }

    // Method to delete the file
    static public void deleteFile() {
        File filePath = new File(FILE_PATH);
        if (filePath.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Error deleting the file.");
        }
    }
}
