package com.example.oopproject;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.geometry.Pos;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Buttons {

    public static Button createButton(String text, Label displayLabel, GridPane gridPane) {
        Button button = new Button(text);

        // Styling the button
        button.setPrefSize(75, 60);
        button.setStyle("-fx-background-color: #1C325B; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
        button.setFont(Font.font("Time new roman ", 20));
        button.setAlignment(Pos.CENTER);

        if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("÷")) {
            button.setStyle("-fx-background-color: #464E3D; -fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
        }
        if (text.equals("=")) {
            button.setStyle("-fx-background-color: #464E3D; -fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");
        }

        // Hover effects
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            button.setStyle("-fx-background-color: #6A669C; -fx-text-fill: white;");
            if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("÷") || text.equals("=")) {
                button.setStyle("-fx-background-color: #60463D; -fx-text-fill: white;");
            }
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            button.setStyle("-fx-background-color: #1C325B; -fx-text-fill: white;");
            if (text.equals("+") || text.equals("-") || text.equals("x") || text.equals("÷") || text.equals("=")) {
                button.setStyle("-fx-background-color: #464E3D; -fx-text-fill: white;");
            }
        });

        // Button Action Handling

        button.setOnAction(e -> {
            String currentText = displayLabel.getText();

            if (text.equals("C")) {
                displayLabel.setText("");
            } else if (text.equals("=")) {
                try {
                    String replacedString = currentText.replace('x', '*').replace('÷', '/');
                    Expression expr = new ExpressionBuilder(replacedString).build();
                    double result = expr.evaluate();
                    displayLabel.setText(String.valueOf(result));
                    // Save expression to file
                    FileHandling.writeFile(currentText + " = " + result);
                } catch (RuntimeException ex) {
                    displayLabel.setText("Error");
                }
            } else if (text.equals("DEL")) {
                if (currentText.length() > 0) {
                    displayLabel.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (text.equals("π")) {
                displayLabel.setText(currentText + Math.PI);
            } else {
                displayLabel.setText(currentText + text);
            }
        });

        return button;
    }
}