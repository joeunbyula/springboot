package com.springboot.core;

import org.junit.jupiter.api.Test;

public class dragon {
    public static int total(int n) {
        int answser;

        int[] egg = new int[n+1];
        int[] dragon = new int[n+1];
        int[] stopEggDragon = new int[n+1];

        int eggDay = 0;
        for(int i=0;i<=n;i++) {
            if(i<2) {
                egg[i] = 1;
            } else {
                int eggCnt = egg[i-1];
                if(i%2==0) {
                    egg[i] = egg[i-1] - 1;
                    eggCnt = egg[i];
                    dragon[i] = dragon[i-1]+1;
                }
                if(i%4==0) {
                    dragon[i] = dragon[i-1] - 1;
                    stopEggDragon[i] = stopEggDragon[i-1]+1;
                }
                egg[i] = eggCnt + dragon[i];
            }

            System.out.println("i = " + i);
            System.out.println("stopEggDragon = " + stopEggDragon[i]);
            System.out.println("dragon = " + dragon[i]);
            System.out.println("egg = " + egg[i]);
            System.out.println("\n");
        }
        answser = egg[n]+dragon[n]+stopEggDragon[n];
        return answser;
    }

    public static void main(String[] args) {
        int total = total(6);
        System.out.println("total = " + total);
    }
}
