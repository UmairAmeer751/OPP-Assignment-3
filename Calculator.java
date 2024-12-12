package com.example.oopproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {
    static final double PI = 3.1416;
    static boolean firstTIME = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Stage Configuration
        primaryStage.setTitle("CALCULATOR BY UMAIR");

        // GridPane Configuration
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: black;");

        // Display Label
        Label displayLabel = new Label("0");
        displayLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-background-color: #1C325B; -fx-padding: 10;");
        displayLabel.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(displayLabel, 0, 0, 4, 1); // Span across 4 columns

        // Buttons Configuration
        String[] buttons = {"7", "8", "9", "÷", "4", "5", "6", "x", "1", "2", "3", "-", "0", ".", "+",
                "SIN", "COS", "TAN", "π", "C", "DEL", "="};
        int gridx = 0, gridy = 1;

        // Loop through the buttons and add them to the grid
        for (String text : buttons) {
            // Directly call the static method to create the button
            var button = Buttons.createButton(text, displayLabel, gridPane);
            gridPane.add(button, gridx, gridy);

            // Update grid position
            gridx++;
            if (gridx == 4) {
                gridx = 0;
                gridy++;
            }
        }

        // Scene Configuration
        Scene scene = new Scene(gridPane, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}




