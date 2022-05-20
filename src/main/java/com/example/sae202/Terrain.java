package com.example.sae202;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class Terrain {
    private Coordonnee coordonnee;

    public GridPane Terrain1(GridPane sect,int x, int y) {

        this.coordonnee = new Coordonnee(x, y);
        int rows1 = 2;
        int columns1 = 2;
        sect = new GridPane();
        sect.setAlignment(Pos.CENTER);

        for (int i = 0; i < columns1; i++) {
            ColumnConstraints column1 = new ColumnConstraints(40);
            sect.getColumnConstraints().add(column1);
        }
        for (int i = 0; i < rows1; i++) {
            RowConstraints row = new RowConstraints(40);
            sect.getRowConstraints().add(row);
        }



        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect;
    }

}