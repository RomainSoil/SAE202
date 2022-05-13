package com.example.sae202;

public class Terrain extends Secteur{

    private boolean occupe;

    public Terrain(int x, int y, boolean occupe) {
        super(x, y);
        this.occupe = occupe;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                secteur[i][j] = "  ";}}
    }

    public Terrain(int x, int y) {
        super(x, y);
        this.occupe= false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                secteur[i][j] = "  ";}}
    }

    public void affichage()
    {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(" | "+secteur[i][j]);

            }
            System.out.println("");
        }
    }
}
