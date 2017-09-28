package ciphers.pr1;


import ciphers.Cipher;
import ciphers.Constants;

import java.util.HashMap;
import java.util.Map;

public class Vizhiner extends Cipher {
    private int keyLength;

    public Vizhiner() {
        key = "cipher";
        keyLength = key.length();

    }

    @Override
    public String encrypt(String word) {
        StringBuffer result = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            char resultChar = (char) (word.charAt(i) + (key.charAt(i % keyLength) % Constants.LC_A_ASCII_INDEX));
            tableOfChange.put(String.valueOf(word.charAt(i)), String.valueOf(resultChar));
            result.append(resultChar);
        }
        System.out.println(result);
        return result.toString();
    }
}
