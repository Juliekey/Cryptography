package ciphers.pr1;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Random;

public class Variant extends Cipher {

    private static char[][] upper = {{'q', 'e', 't', 'u', 'o', 'a'}, {'w', 'r', 'y', 'i', 'p', 's'}};
    private static char[][] side = {{'d', 'g', 'j', 'l', 'x'}, {'f', 'h', 'k', 'z', 'c'}};
    private char[][] arr = new char[side[0].length][upper[0].length];
    private ArrayDeque<Character> order = new ArrayDeque<>();
    Random rnd = new Random();

    public Variant() {
        name = "Variant";
        key = "cipher";
    }

    private void createOrder(String key) {
        StringBuffer sb = new StringBuffer(Constants.ALPHABET);
        for (int k = 0; k < key.length(); k++) {
            if (sb.indexOf(String.valueOf(key.charAt(k))) != -1) {
                order.add(key.charAt(k));
                sb.deleteCharAt(sb.indexOf(String.valueOf(key.charAt(k))));
            }
        }
        while (sb.length() != 0) {
            order.add(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; !order.isEmpty() && j < arr[i].length; j++) {
                arr[i][j] = order.getFirst();
                order.removeFirst();
            }
        }
    }

    public String encrypt(String word) {
        StringBuffer encrypted = new StringBuffer();
        createOrder(key);
        int count = 0;

        while (count < word.length()) {
            outerloop:
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    char current = word.charAt(count);
                    if (arr[i][j] == current) {
                        String encryptedChar = "" + side[rnd.nextInt(2)][i] + upper[rnd.nextInt(2)][j];
                        encrypted.append(encryptedChar);
                        tableOfChange.add(new Pair<String, String>(String.valueOf(current), encryptedChar));
                        count++;
                        break outerloop;
                    }
                }
            }
        }
        return encrypted.toString();
    }
}
