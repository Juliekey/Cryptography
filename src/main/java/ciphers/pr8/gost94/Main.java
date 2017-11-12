package ciphers.pr8.gost94;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ClientA a = new ClientA();
        a.generate();
        ClientB b = new ClientB();
        getResult(a, b, "pri");
    }
    public static void getResult(ClientA a, ClientB b, String word){
        StringBuffer sb = new StringBuffer();
        boolean res;
        for(int i = 0; i < word.length(); i++){
            a.send(word.charAt(i));
            res = b.authentificate(word.charAt(i), a.getQ(), a.getS(), a.getR1(), a.getG(), a.getY(), a.getP());
            System.out.println(res);
        }
        System.out.println(sb);
    }
}
