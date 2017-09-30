package ciphers.pr1;

import ciphers.Cipher;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class PolybiusSquare extends Cipher {
    Map<Character, String> polibiusMap = new HashMap<>();

    public PolybiusSquare() {
        polibiusMap.put('a', "11");
        polibiusMap.put('b', "12");
        polibiusMap.put('c', "13");
        polibiusMap.put('d', "14");
        polibiusMap.put('e', "15");
        polibiusMap.put('f', "21");
        polibiusMap.put('g', "22");
        polibiusMap.put('h', "23");
        polibiusMap.put('i', "24");
        polibiusMap.put('j', "24");
        polibiusMap.put('k', "25");
        polibiusMap.put('l', "31");
        polibiusMap.put('m', "32");
        polibiusMap.put('n', "33");
        polibiusMap.put('o', "34");
        polibiusMap.put('p', "35");
        polibiusMap.put('q', "41");
        polibiusMap.put('r', "42");
        polibiusMap.put('s', "43");
        polibiusMap.put('t', "44");
        polibiusMap.put('u', "45");
        polibiusMap.put('v', "51");
        polibiusMap.put('w', "52");
        polibiusMap.put('x', "53");
        polibiusMap.put('y', "54");
        polibiusMap.put('z', "55");

    }

    public String encrypt(String word) {
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            char current = word.charAt(i);
            String encryptedChar = polibiusMap.get(current);
            encrypted.append(encryptedChar + " ");
            tableOfChange.add(new Pair<String, String>(String.valueOf(current), encryptedChar));
            System.out.println();
        }
        return encrypted.toString().trim();
    }
}
