package com.example.sae202;

public class Robot extends Coordonnee

{
    private int  numRobot;
    private int capStokage;
    private int capExtraction;
    private int nbMinAct;
    private int Stockage;

    public Robot(int x, int y, int num, int cS, int cE, int nbM, int stc)
    {
        super(x,y);
        numRobot = num;
        capStokage = cS;
        capExtraction = cE;
        nbMinAct = nbM;
        Stockage = stc;

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
        if (capStokage > 0 && capExtraction > 0 && mine.getNbMinerais() > 0)
        {
            capExtraction -=1;
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

    }

}

