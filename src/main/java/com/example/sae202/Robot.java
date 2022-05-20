package com.example.sae202;

public class Robot

{
    private int x;
    private int y;
    private int  numRobot;
    private int capStokage;
    private int capExtraction;
    private int nbMinAct;
    private int Stockage;
    private int Extraction;

    public Robot(int x, int y, int num, int cS, int cE, int nbM, int stc)
    {
        this.x=x;
        this.y=y;
        numRobot = num;
        capStokage = cS;
        capExtraction = cE;
        nbMinAct = nbM;
        Stockage = stc;
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
    public void Nord() throws DepassementMonde_Exception {
        this.y = this.y + 1;
        if (this.y == 0) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

    public void Sud () throws DepassementMonde_Exception {
        this.y = this.y - 1;
        if (this.y == 10) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

    public void Ouest ()throws DepassementMonde_Exception
    { this.x = this.x - 1;
        if (this.x == 0) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

    public void Est ()throws DepassementMonde_Exception
    {
        this.x = this.x + 1;
        if (this.x == 10) {
            DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
            throw DE;
        }
    }

}



