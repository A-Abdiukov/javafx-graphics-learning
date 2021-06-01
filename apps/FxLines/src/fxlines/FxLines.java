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

public class FxLines extends Application {

    Line line1;
    Pane root = new Pane();
    int x1 = 0;
    int y1 = 50;
    int x2 = 120;
    int y2 = 120;
    int x3 = 220;
    int y3 = 120;
    int delta = 12;

    @Override
    public void start(Stage primaryStage) {

        // Button that creates rectangles
        Button BtnRectangle = new Button();
        BtnRectangle.setLayoutX(x1);
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

        //Button that creates circle
        Button BtnCircle = new Button();
        BtnCircle.setLayoutX(x2);
        BtnCircle.setText("Draw a circle");
        BtnCircle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x2 += delta;
                y2 += delta;
                Circle circle = new Circle(x2, y2, 50);
                circle.setFill(Color.BURLYWOOD);
                circle.setStrokeWidth(8.0);
                circle.setStroke(Color.CORNFLOWERBLUE);
                root.getChildren().add(circle);
            }
        });
        root.getChildren().add(BtnCircle);

        //Button that creates arc
        Button BtnArc = new Button();
        BtnArc.setLayoutX(x3);
        BtnArc.setText("Draw an arc");
        BtnArc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x3 += delta;
                y3 += delta;
                Arc arc = new Arc(x3, y3, 100.0f, 100.0f, 0.0f, 100.0f);
                arc.setFill(Color.CRIMSON);
                arc.setStrokeWidth(8.0);
                arc.setStroke(Color.DARKKHAKI);
                root.getChildren().add(arc);
                x3 += delta * 3;
                y3 += delta * 3;
            }
        });
        root.getChildren().add(BtnArc);

        root.setStyle("-fx-background-color: #a2d5c6");

        Scene scene = new Scene(root, 700, 700);

        primaryStage.setTitle("Draw cool shapes!");
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
