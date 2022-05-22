package com.example.sae202;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Monde {

    private Secteur[][] leMonde;


    public boolean EstPasLibre(int x, int y)
    {
        if (leMonde[x][y] instanceof Terrain){
            return false;
        }
        else {return true;}
    }


    public Monde() {
        this.leMonde = new Secteur[10][10];
        for(int i=0 ; i < 10;i++){
            for (int j = 0; j < 10;j++) {
                leMonde[i][j] = new Terrain(i,j);
            }}

        Random2 random2= new Random2(1,10);
        int g = random2.getValue();
        for (int i=0;i<=g;i++)

        {
            Random2 randomX=new Random2(0,10);
            Random2 randomY=new Random2(0,10);
            int x=randomX.getValue();
            int y=randomY.getValue();
            while (this.EstPasLibre(x,y))
            {
                x=new Random2(0,10).getValue();
                y=new Random2(0,10).getValue();
            }



            leMonde[x][y]=new PlanDeau(x,y);

        }

        for (int i=0;i<2;i++) {
            Random2 randomX = new Random2(0, 10);
            Random2 randomY = new Random2(0, 10);
            int x = randomX.getValue();
            int y = randomY.getValue();
            while (this.EstPasLibre(x,y))
            {
                x=new Random2(0,10).getValue();
                y=new Random2(0,10).getValue();
            }


            leMonde[x][y] =new Entrepot(x, y,i);
        }
        for (int i=0;i<2;i++)
        {
            Random2 randomX2=new Random2(0,10);
            Random2 randomY2=new Random2(0,10);
            int x=randomX2.getValue();
            int y=randomY2.getValue();
            while (this.EstPasLibre(x,y))
            {
                x=new Random2(0,10).getValue();
                y=new Random2(0,10).getValue();
            }

            leMonde[x][y]= new Mine(x, y,i);


        }
    }
     public void affichage(GridPane grid) {





         for (int i = 1; i < 11; i++) {
             for (int j = 1; j < 11; j++) {
                 if (leMonde[i-1][j-1] instanceof Terrain) {
                     GridPane sect = ((Terrain) leMonde[i-1][j-1]).Terrain1(grid, i, j);
                     grid.setColumnIndex(sect,i);
                     grid.setRowIndex(sect,j);
                     grid.getChildren().add(sect);
                 } else if (leMonde[i-1][j-1] instanceof PlanDeau) {
                     GridPane sect =((PlanDeau) leMonde[i-1][j-1]).PD(grid, i, j);
                     grid.setColumnIndex(sect,i);
                     grid.setRowIndex(sect,j);
                     grid.getChildren().add(sect);
                 } else if (leMonde[i-1][j-1] instanceof Entrepot) {
                     GridPane sect=((Entrepot) leMonde[i-1][j-1]).Entrepot(grid, i, j, ((Entrepot) leMonde[i-1][j-1]).getNumEnt());
                     grid.setColumnIndex(sect,i);
                     grid.setRowIndex(sect,j);
                     grid.getChildren().add(sect);
                 } else if (leMonde[i-1][j-1] instanceof Mine) {
                     GridPane sect=((Mine) leMonde[i-1][j-1]).Mine(grid, i, j, ((Mine) leMonde[i-1][j-1]).getNumM());
                     grid.setColumnIndex(sect,i);
                     grid.setRowIndex(sect,j);
                     grid.getChildren().add(sect);
                 }

             }
         }


     }


}
