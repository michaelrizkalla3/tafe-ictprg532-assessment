/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotate_transition;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;  
import javafx.scene.transform.Rotate;  
import javafx.stage.Stage;  
import javafx.util.Duration;  

/**
 *
 * @author User
 */
public class Rotate_Transition extends Application {
    
   @Override  
    public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub  


        //Creating Rectangle   
        Rectangle rect = new Rectangle(200,100,200,200);  
        rect.setFill(Color.LIMEGREEN);  
        rect.setStroke(Color.HOTPINK);  
        rect.setStrokeWidth(5);

       ParallelTransition parallelTransition = new ParallelTransition();

        //Instantiating RotateTransition class   
        RotateTransition rotate = new RotateTransition();  
          
        //Setting Axis of rotation   
        rotate.setAxis(Rotate.Z_AXIS);  
          
        // setting the angle of rotation   
        rotate.setByAngle(360);  
          
        //setting cycle count of the rotation   
        rotate.setCycleCount(500);  
          
        //Setting duration of the transition   
        rotate.setDuration(Duration.millis(1000));  
          
        //the transition will be auto reversed by setting this to true   
        rotate.setAutoReverse(true);  
              
        //setting Rectangle as the node onto which the   
// transition will be applied  
        rotate.setNode(rect);  
          
        //playing the transition   
//        rotate.play();
          parallelTransition.getChildren().add(rotate);

       FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), rect);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0.3);
       fadeTransition.setCycleCount(500);
       fadeTransition.setAutoReverse(true);
       parallelTransition.getChildren().add(fadeTransition);

       ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), rect);
       scaleTransition.setToX(2);
       scaleTransition.setToY(2);
       scaleTransition.setCycleCount(500);
       scaleTransition.setAutoReverse(true);
       parallelTransition.getChildren().add(scaleTransition);
        //Configuring Group and Scene
        Group root = new Group();  
        root.getChildren().add(rect);  
        Scene scene = new Scene(root,600,400,Color.BLACK);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Rotate Transition example");  
        primaryStage.show();

       parallelTransition.play();
   }
    public static void main(String[] args) {  
        launch(args);  
    }  
  
}  