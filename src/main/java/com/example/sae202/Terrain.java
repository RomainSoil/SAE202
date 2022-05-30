package com.example.sae202;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class Terrain extends Secteur{
    public Terrain(int x, int y) {
        this.x = x;
        this.y=y;
    }

    private int x;
    private int y;
    private Robot robot;




    public GridPane Terrain1(GridPane sect,int x, int y) {

        this.x = x;
        this.y = y;
        int rows1 = 2;
        int columns1 = 2;
        sect = new GridPane();
        sect.setAlignment(Pos.CENTER);

        for (int i = 0; i < columns1; i++) {
            ColumnConstraints column1 = new ColumnConstraints(35);
            sect.getColumnConstraints().add(column1);
        }
        for (int i = 0; i < rows1; i++) {
            RowConstraints row = new RowConstraints(35);
            sect.getRowConstraints().add(row);
        }



        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect;
    }

    public GridPane Terrain2(GridPane sect,int x, int y) {

        this.x = x;
        this.y = y;
        int rows1 = 2;
        int columns1 = 2;
        sect = new GridPane();
        sect.setAlignment(Pos.CENTER);

        for (int i = 0; i < columns1; i++) {
            ColumnConstraints column1 = new ColumnConstraints(35);
            sect.getColumnConstraints().add(column1);
        }
        for (int i = 0; i < rows1; i++) {
            RowConstraints row = new RowConstraints(35);
            sect.getRowConstraints().add(row);
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 1; j++) {
                Text text = new Text("    R");
                Text txt = new Text("  "+String.valueOf(robot.getNumRobot()));
                sect.setColumnIndex(text, j);
                sect.setColumnIndex(txt,j+1);
                sect.setRowIndex(text, i);
                sect.setRowIndex(txt, i);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }}



        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect;
    }

    public void setrobot1(Robot robo) {
        robot = robo;
    }

    public void setrobot2() {
        robot = null;
    }


    public boolean getRobotPresent() {
        if (robot==null)
            return false;
        else
            return true;

    }
}