package ciphers.pr1;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

public class Ceasar extends Cipher {
    int shift = 3;
    public Ceasar() {
        name = "Caesar";
        key = String.valueOf(shift);
    }

    public String encrypt(String word) {
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            char current = word.charAt(i);
            int index = Constants.ALPHABET.indexOf(current);
            char encryptedChar = Constants.ALPHABET.charAt((index+shift)% ciphers.Constants.EN_ALPHABET_CNT);
            encrypted.append(encryptedChar);
            tableOfChange.add(new Pair<String, String>(String.valueOf(current), String.valueOf(encryptedChar)));
        }
        return encrypted.toString();
    }
}
