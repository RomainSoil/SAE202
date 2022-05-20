package com.example.sae202;

import java.util.Random;

public class Random2 {

    private int value;

    public  Random2(int min, int max) {


        Random random = new Random();

    this.value = random.nextInt(max + min) + min;
		System.out.println(value);

    }

    public int getValue() {
        return value;
    }
}
