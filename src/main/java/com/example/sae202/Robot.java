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
    private static int Extraction =3;

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
        Extraction = new Random2(0,4).getValue() ;

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

        if (Stockage+3<=capStokage &&mine.getNature().equals(this.getType())&&mine.getNbMinerais()>=3 && mine.getRobotPresent()==true) {
            Stockage += 3;
            mine.nbMinerais -= 3;
        }
        else if (mine.getNature().equals(this.getType()) && mine.getNbMinerais()<3 && Stockage+mine.getNbMinerais()<=capStokage && mine.getRobotPresent()==true)
        {
            Stockage+=mine.getNbMinerais();
            mine.nbMinerais=0;
        }

        else if (mine.getNature().equals(this.getType())&& Stockage<capStokage && Stockage+3>capStokage && mine.getRobotPresent()==true)
        {
            int nb=capStokage-Stockage;
            Stockage+=nb;
            mine.nbMinerais-=nb;
        }


        if (capStokage < 1 || capStokage < Stockage){
            DepassementStockage_Exception depStock = new DepassementStockage_Exception("Votre stockage est plein");
            throw depStock;}
        if (capExtraction <1 ){
            DepassementCapaciteExtraction depExtract = new DepassementCapaciteExtraction("Votre capacité d'extraction est dépassé");
            throw depExtract;}



    }

    public void deposer(Entrepot entrepot) throws DepassementStockage_Exception, SecteurContenance_Exception
    {
        if (entrepot.getNatureStock().equals(this.getType()) && entrepot.getRobotPresent()==true )
            {
                entrepot.setStock(entrepot.getStock() + this.getStockage());

                this.Stockage=0;

            }

        /*if (entrepot.getStock() - this.Stockage < 0 || entrepot.getStockInit() - entrepot.getStock() < 0)
        {
            DepassementStockage_Exception DS = new DepassementStockage_Exception("Le stockage est devenu négatif !");
            throw DS;
        }*/
        if ((!(entrepot.getNatureStock().equals(this.getType())))&& entrepot.getRobotPresent()==true)
        {
            SecteurContenance_Exception SC = new SecteurContenance_Exception();
            throw SC;

        }
    }
    public void Nord(Monde leMonde) throws DepassementMonde_Exception {

        if (this.y == 0 || leMonde.leMonde[x][y-1] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }

        else{
        leMonde.leMonde[x][y].setrobot2();
        this.y = this.y-1;
        leMonde.leMonde[x][y].setrobot1(this);
        /*if (leMonde.leMonde[x][y] instanceof Mine)
        {

        }*/
        }


    }

    public void Sud (Monde leMonde) throws DepassementMonde_Exception {

        if (this.y == 10 || leMonde.leMonde[x][y+1] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else
        {
        leMonde.leMonde[x][y].setrobot2();
        this.y = this.y + 1;
        leMonde.leMonde[x][y].setrobot1(this);}
    }

    public void Ouest (Monde leMonde)throws DepassementMonde_Exception
    {
        if (this.x == 0 || leMonde.leMonde[x-1][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else{
        leMonde.leMonde[x][y].setrobot2();
        this.x = this.x - 1;
        leMonde.leMonde[x][y].setrobot1(this);}

    }

    public void Est (Monde leMonde)throws DepassementMonde_Exception
    {
        if (this.x == 10 || leMonde.leMonde[x+1][y] instanceof PlanDeau) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous ne pouvez pas aller plus loin !");
            throw DE;
        }
        else {
        leMonde.leMonde[x][y].setrobot2();
        this.x = this.x + 1;
        leMonde.leMonde[x][y].setrobot1(this);}

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return Type;
    }

    public int getStockage() {
        return Stockage;
    }
}
