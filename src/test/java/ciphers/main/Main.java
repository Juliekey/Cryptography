package ciphers.main;

import ciphers.*;
import ciphers.pr2.*;

public class Main {
    public static void main(String[] args) {
        String word = "Great Britain";
        Cipher cipher = new CardanGrille();
        String result = cipher.encrypt(word);
        System.out.println("Encrypted:" + result);
        System.out.println("Key: " + cipher.getKey());
        System.out.println("Table of changes: " + cipher.getTableOfChange());

    }
}
