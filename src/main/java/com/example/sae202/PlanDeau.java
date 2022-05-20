package com.example.sae202;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class PlanDeau extends Secteur{
    private int x;
    private int y;

    public PlanDeau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GridPane PD(GridPane sect, int x, int y) {

        this.x=x;
        this.y=y;
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
        for (int i = 0; i < columns1; i++) {
            for (int j = 0; j < rows1; j++) {
                Text text = new Text("    X");
                sect.setColumnIndex(text, i);
                sect.setRowIndex(text, j);
                sect.getChildren().add(text);
            }
        }


        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect;
    }

}