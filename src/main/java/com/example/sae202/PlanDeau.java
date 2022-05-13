package com.example.sae202;

public class PlanDeau extends Secteur {
    public PlanDeau(int x, int y) {
        super(x, y);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                secteur[i][j] = "x";
            }
        }
    }

}