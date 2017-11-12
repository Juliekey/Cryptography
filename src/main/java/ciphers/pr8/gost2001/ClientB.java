package ciphers.pr8.gost2001;

import ciphers.Constants;

public class ClientB {
    int calculateH(char ch){
        return Constants.ALPHABET.indexOf(ch);
    }
    int calculateE(int h, int q){
        return h%q;
    }
    int calculateZ1(int s, int v, int q){
        return (s*v)%q;
    }
    int calculateZ2(int r, int v, int q){
        return ((q-r)*v)%q;
    }
    int calculateR(int xc, int q){
        return xc%q;
    }
}
