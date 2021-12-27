/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxrectangle;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

import static java.lang.Math.floor;

/**
 *
 * @author shubh
 */
public class FxRectangle extends Application {

    static int dim = 8;

    private double stageHt, stageWd, midX, midY;

    @Override
    public void start(Stage primaryStage) {
        boolean[][] locations = new boolean[dim][dim];
        primaryStage.setTitle("working with FX rectangle");
        
        //create a group, all GUI elements will be added to this group
        //the group is then added to primaryStage
        Group grp = new Group();
        Scene newScene = new Scene(grp, 500, 500, Color.BURLYWOOD);
        Rectangle rect = new Rectangle();
        stageHt = (int)newScene.getHeight();
        stageWd = (int)newScene.getWidth();
        rect.setHeight(50);
        rect.setWidth(50);
        rect.setFill(Color.AQUAMARINE);
        //put rectangle in the centre
        int midLocation = (int) floor(dim / 2);
        midX = 60 * midLocation; // midway location
        midY = 60 * midLocation;
        locations[midLocation][midLocation] = true;
        rect.setX(midX + 10);
        rect.setY(midY + 10);

        EventHandler<MouseEvent> spinAndSpawnEventHandler = new SpinAndSpawn(grp, locations);

        rect.addEventHandler(MouseEvent.MOUSE_CLICKED, spinAndSpawnEventHandler);

        grp.getChildren().add(rect);
        
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    class SpinAndSpawn implements EventHandler<MouseEvent> {
        private Group parent;
        private boolean[][] locations;
        public SpinAndSpawn(Group parent, boolean[][] locations) {
            this.parent = parent;
            this.locations = locations;
        }

        @Override
        public void handle(MouseEvent event) {
            // spin
            Rectangle eventRectangle = (Rectangle) event.getSource();
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), eventRectangle);
            rotateTransition.setByAngle(180);
            rotateTransition.setCycleCount(100);
            rotateTransition.play();

            //create new square
            Random random = new Random();
            boolean empty = false;
            int attempt = 0;
            do {
                int randX = random.nextInt(dim);
                int randY = random.nextInt(dim);
                if(locations[randX][randY] == false) {
                    locations[randX][randY] = true;
                    empty = true;

                    Rectangle newRect = new Rectangle(50, 50, Color.AQUAMARINE);
                    newRect.setX((randX * 60) + 10);
                    newRect.setY((randY * 60) + 10);
                    newRect.addEventHandler(MouseEvent.MOUSE_CLICKED, new SpinAndSpawn(parent, locations));

                    parent.getChildren().add(newRect);
                }
                attempt++;
            } while(!empty && attempt < 100);

        }
    };
}
