package ciphers.pr8.gost2001;

import ciphers.Constants;

import java.util.Random;

public class ClientA {
    Random rnd = new Random();
    int h;
    int d;
    int calculateH(char ch){
        return Constants.ALPHABET.indexOf(ch);
    }
    int calculateE(int h, int q){
        return h%q;
    }

    int calculateK(int q){
        return rnd.nextInt(q);
    }
    int calculateR(int xc, int q){
        return xc%q;
    }
    int calculateS(int xc, int q, int r, int k, int e){
        return (r*d+k*e)%q;
    }
}
