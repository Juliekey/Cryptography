package ciphers;


import java.util.HashMap;
import java.util.Map;

public class Vizhiner extends Cipher {
    private int keyLength = key.length();
    private Map<Character, Character> tableOfChange = new HashMap<>();

    public Vizhiner() {
        key = "cipher";
    }

    @Override
    public String encrypt(String word) {
        StringBuffer result = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            char resultChar = (char) (word.charAt(i) + (key.charAt(i % keyLength) % Constants.LC_A_ASCII_INDEX));
            tableOfChange.put(word.charAt(i), resultChar);
            result.append(resultChar);
        }
        System.out.println(result);
        return result.toString();
    }
}
