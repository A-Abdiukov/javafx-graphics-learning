/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotate_transition;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    Boolean isEyesRotating = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Instantiating RotateTransition class
        RotateTransition rotate = new RotateTransition();
        //Setting Axis of rotation
        rotate.setAxis(Rotate.Z_AXIS);
        // setting the angle of rotation
        rotate.setByAngle(360);
        //setting cycle count of the rotation
        rotate.setCycleCount(500);
        //Setting duration of the transition
        rotate.setDuration(Duration.millis(7000));

        //Instantiating RotateTransition class
        RotateTransition rotate2 = new RotateTransition();
        //Setting Axis of rotation
        rotate2.setAxis(Rotate.Z_AXIS);
        // setting the angle of rotation
        rotate2.setByAngle(360);
        //setting cycle count of the rotation
        rotate2.setCycleCount(500);
        //Setting duration of the transition
        rotate2.setDuration(Duration.millis(7000));

        //Creating Rectangle 1
        Rectangle rect = new Rectangle(150, 50, 50, 50);
        rect.setFill(Color.BROWN);
        rect.setStroke(Color.WHITE);
        rect.setStrokeWidth(5);
        rotate.setNode(rect);

        //Creating Rectangle 2
        Rectangle rect2 = new Rectangle(50, 50, 50, 50);
        rect2.setFill(Color.BROWN);
        rect2.setStroke(Color.WHITE);
        rect2.setStrokeWidth(5);
        rotate2.setNode(rect2);

        //Creating rectangle 3 - mouth
        Rectangle rect3 = new Rectangle(50, 150, 150, 50);
        rect3.setFill(Color.BROWN);
        rect3.setStroke(Color.WHITE);
        rect3.setStrokeWidth(5);

        //creating rectangle 4 - face
        Rectangle rect4 = new Rectangle(20, 20, 210, 200);
        rect4.setFill(Color.YELLOW);
        rect4.setStroke(Color.WHITE);
        rect4.setStrokeWidth(5);

        //creating button that starts rotation and ends rotation
        Button Btn_StartRotation = new Button("Rotate the eyes");
        Btn_StartRotation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isEyesRotating) {
                    rotate.stop();
                    rotate2.stop();
                } else {
                    rotate.play();
                    rotate2.play();
                }
                isEyesRotating = !isEyesRotating;
            }
        });
        Btn_StartRotation.setLayoutY(230);

        //Configuring Group and Scene
        Group root = new Group();

        root.getChildren().add(rect4);
        root.getChildren().add(rect);
        root.getChildren().add(rect2);
        root.getChildren().add(rect3);
        root.getChildren().add(Btn_StartRotation);

        Scene scene = new Scene(root, 250, 300, Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smiley face");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
