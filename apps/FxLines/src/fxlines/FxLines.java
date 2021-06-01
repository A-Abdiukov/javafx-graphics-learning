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
import javafx.scene.shape.*;
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
        x1 = 0;
        x2 = 120;
        y1 = 50;
        y2 = 120;
        Button BtnRectangle = new Button();
        BtnRectangle.setText("Draw a rectangle");
        BtnRectangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x1 += delta;
                y1 += delta;
                Rectangle rectangle = new Rectangle(x1, y1, 100, 100);
                rectangle.setFill(Color.DARKCYAN);
                rectangle.setStrokeWidth(8.0);
                rectangle.setStroke(Color.DARKSLATEGREY);
                root.getChildren().add(rectangle);

            }
        });
        root.getChildren().add(BtnRectangle);

        Button BtnCircle = new Button();
        BtnRectangle.setText("Draw a circle");
        BtnRectangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x1 += delta;
                y1 += delta;
                Rectangle rectangle = new Rectangle(x1, y1, 100, 100);
                rectangle.setFill(Color.DARKCYAN);
                rectangle.setStrokeWidth(8.0);
                rectangle.setStroke(Color.DARKSLATEGREY);
                root.getChildren().add(rectangle);
            }
        });
        root.getChildren().add(BtnCircle);

        root.setStyle("-fx-background-color: #a2d5c6");

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
