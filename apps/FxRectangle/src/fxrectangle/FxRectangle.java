/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxrectangle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FxRectangle extends Application {

    private double stageHt, stageWd, midX, midY;
    private Scene newScene;
    private Rectangle rect;
    Image javaIsFunImage = new Image("file:javaisfun.jpg");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Funny picture always in centre of screen");

        //create a group, all GUI elements will be added to this group
        //the group is then added to primaryStage
        Group grp = new Group();
        newScene = new Scene(grp, 450, 400, Color.ALICEBLUE);

        //add event listeners to detect resizing
        newScene.widthProperty().addListener((obs, oldVal, newVal) -> {
            PutRectangleInTheMiddle();
        });
        newScene.heightProperty().addListener((obs, oldVal, newVal) -> {
            PutRectangleInTheMiddle();
        });

        rect = new Rectangle();
        rect.setHeight(70);
        rect.setWidth(250);
        rect.setFill(new ImagePattern(javaIsFunImage));
        rect.setFill(Color.BLUE);
        PutRectangleInTheMiddle();
        grp.getChildren().add(rect);
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    private void PutRectangleInTheMiddle() {
        //put rectangle in the centre
        stageHt = newScene.getHeight();
        stageWd = newScene.getWidth();
        midX = (stageWd - rect.getWidth()) / 2;
        midY = (stageHt - rect.getHeight()) / 2;
        rect.setX(midX);
        rect.setY(midY);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
