package ciphers;

public class Ceasar extends Cipher {

    private static String chars = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String word) {
        int shift = 3;
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            char current = word.charAt(i);
            int index = chars.indexOf(current);
            char encryptedChar = chars.charAt((index+shift)% ciphers.Constants.EN_ALPHABET_CNT);
            encrypted.append(encryptedChar);
            tableOfChange.put(String.valueOf(current), String.valueOf(encryptedChar));
        }
        return encrypted.toString();
    }
}
