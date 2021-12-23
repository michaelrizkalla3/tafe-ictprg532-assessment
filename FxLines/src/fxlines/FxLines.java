/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxlines;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

/**
 *
 * @author shubh
 */
public class FxLines extends Application {
    Line line1;
    Pane root = new Pane();
    int x1, x2, y1, y2;
    double red, green, blue;
    int change = 0;
    int delta = 12;
    @Override
    public void start(Stage primaryStage) {
        int sceneWidth = 300, sceneHeight = 500;
        x1 = 10; x2 = 10; y1 =100; y2 = 150;
        Button btn = new Button();        
        btn.setText("Draw 1 line");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int[] end = randomPoint(sceneWidth, sceneHeight);
                x1 = x2;
                y1 = y2;
                x2 = end[0];
                y2 = end[1];
                Line line = new Line(x1,y1,x2,y2);
                System.out.println(change);
                if(change == 0) {
                    red = nextShade(red);
                    change++;
                } else if (change == 1) {
                    green = nextShade(green);
                    change++;
                } else {
                    blue = nextShade(blue);
                    change = 0;
                }
                line.setStroke(Color.color(red, green, blue));
                line.setStrokeWidth(2);
                root.getChildren().add(line);
            }
        });             
        
        root.setStyle("-fx-background-color: #FAEBD7");
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        
        primaryStage.setTitle("Draw lines, one at a time");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public int[] randomPoint(int maxX, int maxY) {
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(maxX);
        result[1] = random.nextInt(maxY);
        return result;
    }

    public double nextShade(double colour) {
        if(colour > 0.899) {
            return 0;
        } else {
            return colour + 0.1;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
