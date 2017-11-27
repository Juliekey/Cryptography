package ciphers.pr6;


import entities.Cipher;

public class Main {
    public static void main(String[] args) {

        String word = "pri";
        Cipher cipher = new MD5();
        String result = cipher.encrypt(word);
        System.out.println("Encrypted:" + result);
        System.out.println("Key: " + cipher.getKey());
       // String res = cipher.decrypt();
       // System.out.println("Decrypted:" + res);

    }
}
