package ciphers.pr8.gost94;

import ciphers.Constants;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClientB{
    int h1;
    int v;
    int z1, z2;
    int u;
    public boolean authentificate(char ch, int q, int s, int r1, int g, int y, int p){
        h1 = Constants.ALPHABET.indexOf(ch);
        v = (int)Math.pow(h1, q-2)%q;
        z1 = (s*v)%q;
        z2 = ((q-r1)*v)%q;
        u = (int)((Math.pow(g, z1)*Math.pow(y, z2))%p)%q;
        return r1==u;
    }
}
