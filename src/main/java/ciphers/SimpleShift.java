package ciphers;

import java.util.Random;

public class SimpleShift extends Cipher{
    private int[] order = {5, 2, 1, 3, 0, 4};
    Random rnd;
/*
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
    */
    public String encrypt(String word) {
        char[] result = new char[word.length()];
        for (int i = 0; i < word.length(); i++){
            result[order[i]] = word.charAt(i);
        }
        return String.valueOf(result);
    }
}
