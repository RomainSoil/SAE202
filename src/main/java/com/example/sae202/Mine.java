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
    private int nbMinerais;
    private String natureMinerais;
    private int capaciteInit;

    public Mine(int x, int y, int nb) {
        this.x = x;
        this.y = y;
        numMine = nb;
        nbMinerais = 150;
        natureMinerais = "nickel";
        capaciteInit = 150;

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
                Text txt = new Text("  " + String.valueOf(numEntrepot + 1));
                sect.setColumnIndex(text, i);
                sect.setColumnIndex(txt, i + 1);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }
        }

        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect;


    }
}