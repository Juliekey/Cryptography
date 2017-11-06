package ciphers.pr7.Shamir;

import ciphers.Constants;

import java.util.Random;

public class Shamir {
    Random rnd = new Random();
    int p, q, n, x, v, vi, s;

    public void generate() {
        p = 5;
        q = 7;
        n = p*q;
        x = rnd.nextInt(n)+1;
        v = (int)Math.pow(x, 2)%n;
        for(int i = 1; i <= 100; i++){
            if(v*i%n==1){
                vi = i;
                break;
            }
        }
        for(int i = 1; i <= 100; i++){
            if(Math.pow(i, 2)%n==vi){
                s = i;
                break;
            }
        }
    }

    public int getS() {
        return s;
    }

    public int getP() {
        return p;
    }

    public int getV() {
        return v;
    }
}
