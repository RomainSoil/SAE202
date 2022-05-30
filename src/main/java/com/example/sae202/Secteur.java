package com.example.sae202;


import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class  Secteur {
    private Robot robot;

    public abstract void setrobot1(Robot robot);
    public abstract void setrobot2();
    public abstract boolean getRobotPresent();




}

