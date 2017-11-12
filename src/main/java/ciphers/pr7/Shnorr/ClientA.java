package ciphers.pr7.Shnorr;

import ciphers.Constants;

import java.math.BigInteger;
import java.util.Random;

public class ClientA {
    Random rnd = new Random();
    protected BigInteger r;
    protected int k, s;
    protected int g, x, y;
    protected int q = 29;
    protected int p = 59;

    public void generate(){
        x = calculateX(q);
        g = calculateG(q, p, 20);
        y = calculateY(g, x, p);
    }

    public int calculateX(int q) {
        return rnd.nextInt(q-1)+1;
    }
    public int calculateG(int q, int p, int bound) {
        do{
            g = rnd.nextInt(bound);
        }
        while (Math.pow(g, q)%p!=1);
        return g;
    }
    public int calculateY(int g, int x, int p) {
        do{
            y = rnd.nextInt(100);
        }
        while ((Math.pow(g, x)*y)%p!=1);
        return y;
    }

    public void setR(char ch){
        k = Constants.ALPHABET.indexOf(ch);
        r = BigInteger.valueOf((int)Math.pow(g, k)%p);
    }

    public void setS(BigInteger e) {
        s = (k+x*e.intValue())%q;
    }

    public BigInteger getR() {
        return r;
    }

    public int getS() {
        return s;
    }

    public int getG() {
        return g;
    }
    public int getY() {
        return y;
    }

    public int getQ() {
        return q;
    }

    public int getP() {
        return p;
    }
}
