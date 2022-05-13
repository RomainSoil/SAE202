package com.example.sae202;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class Monde extends Application {

    static GridPane grid;
    public void start(final Stage stage) throws Exception {
        Text text1 = new Text("X");
        int rows = 10;
        int columns = 10;
        stage.setTitle("Monde");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(80);
            grid.getColumnConstraints().add(column);
        }
        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(80);
            grid.getRowConstraints().add(row);
        }


        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        Scene scene = new Scene(grid, Color.WHITE);
        stage.setScene(scene);
        stage.show();
    }
    public static void Main(String[] args) {
        launch(args);
    }
}

