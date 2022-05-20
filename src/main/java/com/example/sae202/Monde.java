package com.example.sae202;

import javafx.scene.layout.GridPane;

public class Monde {

    private Secteur[][] leMonde;
    private Entrepot entrepot;
    private Mine mine;
    private PlanDeau pd;
    private Terrain terrain;

    public boolean estPasLibre(int x, int y)
    {
        if (leMonde[x][y] instanceof Terrain)
        {
            return false;
        }
        else {return true;}
    }

    public Monde() {
        this.leMonde = new Secteur[10][10];
        for(int i=1 ; i < 10;i++){
            for (int j = 1; j < 10;j++) {
                terrain = new Terrain();
                leMonde[i][j] = terrain;
            }}

        Random2 random2= new Random2(1,10);
        int g = random2.getValue();
        for (int i=0;i<=g;i++)

        {
            Random2 randomX=new Random2(1,9);
            Random2 randomY=new Random2(1,9);
            int x=randomX.getValue();
            int y=randomY.getValue();
            while (this.estPasLibre(x,y)) {
                randomX=new Random2(1,9);
                randomY=new Random2(1,9);
                x=randomX.getValue();
                y=randomY.getValue();
            }
            pd = new PlanDeau(x,y);
            leMonde[x][y]=pd;

        }

        for (int i=0;i<2;i++) {
            Random2 randomX = new Random2(1, 9);
            Random2 randomY = new Random2(1, 9);
            int x = randomX.getValue();
            int y = randomY.getValue();
            while (this.estPasLibre(x, y)) {
                randomX = new Random2(1, 9);
                randomY = new Random2(1, 9);
                x = randomX.getValue();
                y = randomY.getValue();
            }
            entrepot = new Entrepot(x, y);
            leMonde[x][y] = pd;
        }
        for (int i=0;i<2;i++)
        {
            Random2 randomX=new Random2(1,9);
            Random2 randomY=new Random2(1,9);
            int x=randomX.getValue();
            int y=randomY.getValue();
            while (this.estPasLibre(x, y)) {
                randomX = new Random2(1, 9);
                randomY = new Random2(1, 9);
                x = randomX.getValue();
                y = randomY.getValue();
            }
            mine = new Mine(x, y);
            leMonde[x][y] = pd;


        }
}  }
