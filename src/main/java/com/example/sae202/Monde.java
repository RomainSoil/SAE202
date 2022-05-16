package com.example.sae202;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.scene.text.TextAlignment.CENTER;

public class Monde extends Application {
    static GridPane sect;
    public GridPane secteur(){
        /*partie secteur*/
        int rows1 = 2;
        int columns1 = 2;
        sect = new GridPane();
        sect.setAlignment(Pos.CENTER);

        for(int i = 0; i < columns1; i++) {
            ColumnConstraints column = new ColumnConstraints(40);
            sect.getColumnConstraints().add(column);
        }
        for(int i = 0; i < rows1; i++) {
            RowConstraints row = new RowConstraints(40);
            sect.getRowConstraints().add(row);
        }
        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect ;
    }
    static GridPane grid;
    public void start(final Stage stage) throws Exception {

        /*partie monde */
        int rows = 11;
        int columns = 11;
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
        for(int i=1 ; i < columns;i++){
            for (int j = 1; j < rows;j++) {
                GridPane sect = secteur();
                grid.setColumnIndex(sect,i);
                grid.setRowIndex(sect,j);
                grid.getChildren().add(sect);
            }
        }
        for(int i=0 ; i < columns;i++){
            for (int j = 0; j < 1;j++) {
                Text text = new Text(String.valueOf(i));
                grid.setColumnIndex(text,i);
                grid.setRowIndex(text,j);
                grid.getChildren().add(text);
            }
        }
        for(int i=0 ; i < 1;i++){
            for (int j = 0; j < rows;j++) {
                Text text = new Text(String.valueOf(j));
                grid.setColumnIndex(text,i);
                grid.setRowIndex(text,j);
                grid.getChildren().add(text);
            }
        }

        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        Scene scene = new Scene(grid,Color.WHITE);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }
    public static void Main(String[] args) {
        launch(args);
    }
}

