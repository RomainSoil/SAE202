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

    public Entrepot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur d'objets de classe Entrepôt
     */


    public Entrepot()
    {
        // initialisation des variables d'instance

        numEntrepot = 0;
        natureStock = "nickel";
        stock = 0;

    }

    public Entrepot(int x, int y, int ne, String ns, int s)
    {
        this.x=x;
        this.y=y;
        numEntrepot = ne;
        natureStock = ns;
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

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < rows1; j++) {
                Text text = new Text("    E");
                Text txt = new Text("  "+String.valueOf(numEntrepot+1));
                sect.setColumnIndex(text, i);
                sect.setColumnIndex(txt,i+1);
                sect.getChildren().add(text);
                sect.getChildren().add(txt);
            }}

        sect.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        return sect;



    }
}
