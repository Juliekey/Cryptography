package ciphers.pr8.gost94;

import ciphers.Constants;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ClientA extends ciphers.pr7.Shnorr.ClientA {
    Random rnd = new Random();
    ArrayList<Integer[]> m = new ArrayList<>();
    int h, r1;
    char message;
    @Override
    public int calculateY(int g, int x, int p) {
        y = (int)Math.pow(g, x)%p;
        return y;
    }
    @Override
    public void generate(){
        g = calculateG(q, p, p);
        x = calculateX(q);
        y = calculateY(g, x, p);
        System.out.println("q="+q);
        System.out.println("g="+g);
        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.println();
    }

    public void send(char ch){
        message = ch;
            h = Constants.ALPHABET.indexOf(ch);
            do {
                setR();
                setS();
            }
            while(r1==0||s==0);
        System.out.println("("+r1+", "+s+")");
    }
    public void setR(){
        k = rnd.nextInt(q);
        r = BigInteger.valueOf((int)Math.pow(g, k)%p);
        r1 = r.intValue()%q;
    }
    public void setS(){
        s = (x*r1+k*h)%q;
    }

    public int getR1() {
        return r1;
    }

    public char getMessage() {
        return message;
    }

    public ArrayList<Integer[]> getM() {
        return m;
    }
}
