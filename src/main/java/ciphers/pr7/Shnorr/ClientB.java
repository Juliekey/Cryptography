package ciphers.pr7.Shnorr;

import java.math.BigInteger;
import java.util.Random;

public class ClientB {
    Random rnd = new Random();
    int t = 52;
    BigInteger e;

    public void setE(){
        e = BigInteger.valueOf(rnd.nextInt((int)Math.pow(2, t)));
    }
    public boolean authentificate(BigInteger r, int g, int s, int y){
        BigInteger big = BigInteger.valueOf((int)Math.pow(g, s)*(int)Math.pow(y, e.doubleValue()));
        return r==big;
    }

    public BigInteger getE() {
        return e;
    }
}
