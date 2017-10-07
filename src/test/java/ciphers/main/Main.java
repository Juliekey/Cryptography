package ciphers.main;

import ciphers.pr2.DoubleShift;
import entities.Cipher;

public class Main {
    public static void main(String[] args) {
        String word = "Great ";
        Cipher cipher = new DoubleShift();
        String result = cipher.encrypt(word);
        System.out.println("Encrypted:" + result);
        System.out.println("Key: " + cipher.getKey());
        System.out.println("Table of changes: " + cipher.getTableOfChange());

    }
}
