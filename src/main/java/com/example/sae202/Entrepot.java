package com.example.sae202;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.util.*;
import java.lang.String;


public class Entrepot extends Secteur
{
    private int x;
    private int y;
    private int numEntrepot;
    private String natureStock;
    private int stock;
    private Robot robot;
    private int stockInit;

    public Entrepot(int x, int y,int nb) {
        this.x = x;
        this.y = y;
        this.numEntrepot=nb;
        natureStock = "nickel";
        this.stockInit=0;
        this.stock=0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Constructeur d'objets de classe EntrepÃ´t
     */


    public Entrepot()
    {
        // initialisation des variables d'instance

        numEntrepot = 0;
        natureStock = "nickel";
        stock = 0;

    }

    public Entrepot(int x, int y, int ne, int s)
    {
        this.x=x;
        this.y=y;
        numEntrepot = ne;
        natureStock = "nickel";
        stock = s;


    }

    public int getNumEnt()
    {
        return numEntrepot;
    }

    public String getNatureE()
    {
        return natureStock;
    }

    public int getStock()
    {
        return stock;
    }

    public GridPane Entrepot(GridPane sect,int x, int y, int numEntrepot) {

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

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < rows1; j++) {
                Text text = new Text("    E");
                Text txt = new Text("  "+String.valueOf(numEntrepot+1));
                sect.setColumnIndex(text, i);
                sect.setColumnIndex(txt,i+1);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }}

        if (getNatureStock().equals("nickel")) {
            sect.setStyle("-fx-background-color: #c0c0c0; -fx-grid-lines-visible: true");
        }
        else if (getNatureStock().equals("OR")){
            sect.setStyle("-fx-background-color: #e9d9c6; -fx-grid-lines-visible: true");
        }
        return sect;



    }

    public GridPane Entrepot2(GridPane sect,int x, int y, int numEntrepot) {


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

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < rows1; j++) {
                Text text = new Text("    E");
                Text txt = new Text("  "+String.valueOf(numEntrepot+1));
                sect.setColumnIndex(text, i);
                sect.setColumnIndex(txt,i+1);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }}

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

        if (getNatureStock().equals("nickel")) {
            sect.setStyle("-fx-background-color: #c0c0c0; -fx-grid-lines-visible: true");
        }
        else if (getNatureStock().equals("OR")){
            sect.setStyle("-fx-background-color: #e9d9c6; -fx-grid-lines-visible: true");
        }
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

    public void setNatureStock(String natureStock) {
        this.natureStock = natureStock;
    }

    public int getNumEntrepot() {
        return numEntrepot;
    }

    public void setNumEntrepot(int numEntrepot) {
        this.numEntrepot = numEntrepot;
    }

    public String getNatureStock() {
        return natureStock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockInit() {
        return stockInit;
    }
}