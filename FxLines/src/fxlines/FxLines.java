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

/**
 *
 * @author shubh
 */
public class FxLines extends Application {
    Line line1;
    Pane root = new Pane();
    int x1, x2, y1, y2;
    int delta = 12;
    @Override
    public void start(Stage primaryStage) {
        x1 = 10; x2 = 10; y1 =100; y2 = 150;
        Button btn = new Button();        
        btn.setText("Draw 1 line");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x1 += delta;
                y2 += delta;
                Line line = new Line(x1,y1,x2,y2);
                line.setStroke(Color.BLUE);
                line.setStrokeWidth(2);
                root.getChildren().add(line);
            }
        });             
        
        root.setStyle("-fx-background-color: #FAEBD7");
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 500);
        
        primaryStage.setTitle("Draw lines, one at a time");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
