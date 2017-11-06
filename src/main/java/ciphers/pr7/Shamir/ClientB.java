package ciphers.pr7.Shamir;

import java.util.Random;

public class ClientB {
    Random rnd = new Random();
    boolean b;
    public boolean getRandomBit(){
        return b = rnd.nextBoolean();
    }
    public  boolean authentificate(int z, int y, int v, int p, int r){
        if(b==true){
            return z==(Math.pow(y, 2)*v)%p;
        }
        else{
            return z==Math.pow(r, 2)%p;
        }
    }
}
