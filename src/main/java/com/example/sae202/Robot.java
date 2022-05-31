package com.example.sae202;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class Robot

{
    private int x;
    private int y;
    private String Type;
    private int  numRobot;
    private int capStokage;
    private int capExtraction;
    private int nbMinAct;
    private int Stockage;
    private int Extraction;

    public Robot(int x, int y, int num, int cS, int cE, int nbM, int stc, String type)
    {
        this.x=x;
        this.y=y;
        numRobot = num;
        capStokage = cS;
        capExtraction = cE;
        nbMinAct = nbM;
        Stockage = stc;
        Type = type;
        Extraction = 0+(int)(Math.random()*((4-0)+1)) ;

    }

    public int getNumRobot()
    {
        return this.numRobot;
    }

    public int getMinAct()
    {
        return this.nbMinAct;
    }

    public int getCapStock()
    {
        return this.capStokage;
    }

    public int getCapExtract()
    {
        return this.capExtraction;
    }

    public void recolter(Mine mine) throws DepassementStockage_Exception,DepassementCapaciteExtraction,CapaciteDeMine
    {
        if (Stockage < capStokage && Extraction < capExtraction && mine.getNbMinerais() > 0)
        {
            Extraction -=1;
            Stockage -=1;
            mine.ExtractionMinerais();

        }
        if (capStokage < 1 || capStokage < Stockage){
            DepassementStockage_Exception depStock = new DepassementStockage_Exception("Votre capacité de stockage est pleine");
            throw depStock;}
        if (capExtraction <1 ){
            DepassementCapaciteExtraction depExtract = new DepassementCapaciteExtraction("Votre capacité d'extraction est dépassé");
            throw depExtract;}
        if (mine.getNbMinerais() < 1){
            CapaciteDeMine CapMine = new CapaciteDeMine("Il n'y a plus de Minerais dans la mine");
            throw CapMine;}


    }
    public void Nord(Monde leMonde) throws DepassementMonde_Exception {

        if (this.y == 0 || leMonde.leMonde[x][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        leMonde.leMonde[x][y].setrobot2();
        this.y = this.y-1;
        leMonde.leMonde[x][y].setrobot1(this);


    }

    public void Sud (Monde leMonde) throws DepassementMonde_Exception {

        if (this.y == 10 || leMonde.leMonde[x][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        leMonde.leMonde[x][y].setrobot2();
        this.y = this.y + 1;
        leMonde.leMonde[x][y].setrobot1(this);
    }

    public void Ouest (Monde leMonde)throws DepassementMonde_Exception
    {
        if (this.x == 0 || leMonde.leMonde[x][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        leMonde.leMonde[x][y].setrobot2();
        this.x = this.x - 1;
        leMonde.leMonde[x][y].setrobot1(this);

    }

    public void Est (Monde leMonde)throws DepassementMonde_Exception
    {
        if (this.x == 10 || leMonde.leMonde[x][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        leMonde.leMonde[x][y].setrobot2();
        this.x = this.x + 1;
        leMonde.leMonde[x][y].setrobot1(this);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
