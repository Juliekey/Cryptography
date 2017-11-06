package ciphers.pr7.Shamir;

import ciphers.Constants;

import java.util.Random;

public class ClientA {
    Random rnd = new Random();
    int r, z, y;

    public void setZ(char ch, int p){
        r = Constants.ALPHABET.indexOf(ch);
        z = (int) Math.pow(r, 2)%p;
    }

    public int getZ() {
        return z;
    }
    public int getRorY(boolean b, int s, int p){
        if(b==true){
            return y = (r * s) % p;
        }
        else {
            return r;
        }
    }

    public int getR() {
        return r;
    }

    public int getY() {
        return y;
    }
}
