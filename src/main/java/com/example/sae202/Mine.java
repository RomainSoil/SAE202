package com.example.sae202;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class Mine extends Secteur {
    private int x;
    private int y;
    private int numMine;
    public int nbMinerais;
    private String natureMinerais;
    private int capaciteInit;
    private Robot robot;

    public Mine(int x, int y, int nb) {
        this.x = x;
        this.y = y;
        numMine = nb;
        nbMinerais = new Random2(50,100).getValue();
        natureMinerais = "nickel";
        capaciteInit = this.getNbMinerais();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Constructeur d'objets de classe Mine
     */




    public Mine(int x, int y, int nm, int nbm, String natM, int ci) {
        this.x = x;
        this.y = y;
        numMine = nm;
        nbMinerais = nbm;
        natureMinerais = natM;
        capaciteInit = ci;
    }

    public int getNumM() {
        return numMine;
    }

    public String getNature() {
        return natureMinerais;
    }

    public int getNbMinerais() {
        return nbMinerais;
    }

    public void ExtractionMinerais() {
        nbMinerais -= 1;
    }

    public int getCapInit() {
        return capaciteInit;
    }

    public GridPane Mine(GridPane sect, int x, int y, int numEntrepot) {

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

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < rows1; j++) {
                Text text = new Text("    M");
                Text txt = new Text("  " + String.valueOf(numMine + 1));
                sect.setColumnIndex(text, i);
                sect.setColumnIndex(txt, i + 1);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }
        }

        if (getNature().equals("nickel")) {
            sect.setStyle("-fx-background-color: #c0c0c0; -fx-grid-lines-visible: true");
        }
        else if (getNature().equals("OR")){
            sect.setStyle("-fx-background-color: #e9d9c6; -fx-grid-lines-visible: true");
        }
        return sect;


    }



    public GridPane Mine2(GridPane sect, int x, int y, int numEntrepot) {

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

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < rows1; j++) {
                Text text = new Text("    M");
                Text txt = new Text("  " + String.valueOf(numMine + 1));
                sect.setColumnIndex(text, i);
                sect.setColumnIndex(txt, i + 1);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }
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

        if (getNature().equals("nickel")) {
            sect.setStyle("-fx-background-color: #c0c0c0; -fx-grid-lines-visible: true");
        }
        else if (getNature().equals("OR")){
            sect.setStyle("-fx-background-color: #e9d9c6; -fx-grid-lines-visible: true");
        }
        return sect;


    }

    public void setNatureMinerais(String natureMinerais) {
        this.natureMinerais = natureMinerais;
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
