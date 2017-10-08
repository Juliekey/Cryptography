package ciphers.pr2;

import entities.Cipher;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;

public class SimpleShift extends Cipher {
    private int[] order;
    Random rnd = new Random();

    public SimpleShift() {

        name = "Simple Shift";
        key = Arrays.toString(order);
    }


        private void add(int size) {
            order = new int[size];
            for (int i = 0; i < order.length; i++){
                order[i] = i;
            }
        }
        private void shuffle() {
            for (int i = order.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                int a = order[index];
                order[index] = order[i];
                order[i] = a;
            }
        }

    public String encrypt(String word) {
        add(word.length());
        shuffle();
        char[] result = new char[word.length()];
        for (int i = 0; i < word.length(); i++){
            result[order[i]] = word.charAt(i);
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(i)), String.valueOf(word.charAt(order[i]))));
        }

        return String.valueOf(result);
    }
}
