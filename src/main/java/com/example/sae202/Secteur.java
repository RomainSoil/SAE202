package com.example.sae202;

public abstract class Secteur extends Coordonnee {
    String[][] secteur;

    public Secteur(int x, int y) {
        super(x, y);
        this.secteur = new String[2][2];
    }

}
