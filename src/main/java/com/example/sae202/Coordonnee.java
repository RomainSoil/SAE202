package com.example.sae202;

public class Coordonnee {
    DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");

    private int x;
    private int y;

    /**
     * Constructeur d'objets de classe Coordonnee j'ecrit un truc pour voir le push
     */
    public Coordonnee()  {
        // initialisation des variables d'instance
        x = 0;
        y = 0;
    }

    public Coordonnee(int vx, int vy) {
        x = vx;
        y = vy;
    }

    public int getPosition() {
        return x + y;
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
