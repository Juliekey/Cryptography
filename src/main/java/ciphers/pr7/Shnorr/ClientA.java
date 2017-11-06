package ciphers.pr7.Shnorr;

import ciphers.Constants;

import java.math.BigInteger;
import java.util.Random;

public class ClientA {
    Random rnd = new Random();
    BigInteger r;
    int k, s;
    int p, q, g, x, y;

    public int generate(){
        q = 29;
        p = 59;
        x = rnd.nextInt(q-1)+1;
        do{
            g = rnd.nextInt(20);
        }
        while (Math.pow(g, q)%p!=1);
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
}
