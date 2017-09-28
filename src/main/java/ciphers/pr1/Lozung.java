package ciphers.pr1;

import ciphers.Cipher;
import ciphers.Constants;

public class Lozung extends Cipher {
    public static char[] chars = {'c', 'i', 'p', 'h', 'e', 'r', 'a', 'b', 'd', 'f', 'g', 'j', 'k',
            'l', 'm', 'n', 'o', 'q', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Lozung() {
        key = "cipher";
    }

    public String encrypt(String word) {
        word = word.toLowerCase();
        StringBuffer encoded = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            char encodedChar = chars[word.charAt(i) - Constants.LC_A_ASCII_INDEX];
            encoded.append(encodedChar);
            tableOfChange.put(String.valueOf(word.charAt(i)), String.valueOf(encodedChar));
            System.out.println();
        }
        return encoded.toString();
    }
}
