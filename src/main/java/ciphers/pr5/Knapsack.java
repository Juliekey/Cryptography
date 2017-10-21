package ciphers.pr5;

import entities.Cipher;
import javafx.util.Pair;

import java.util.Arrays;

public class Knapsack extends Cipher{
    int[] weight = {2, 5, 8, 21, 40, 92, 174, 345};
    int[] result = new int[8];
    String binary;

    public Knapsack(){
        name = "Knapsack";
        key = Arrays.toString(weight);
    }

    @Override
    public String encrypt(String word) {
        for(int i = 0; i < word.length(); i++){
            int count = 0;
            binary = Integer.toBinaryString(word.charAt(i));
            for(int j = 0; j < binary.length(); j++){
                if(binary.charAt(j)=='1'){
                    count += weight[j];
                }
            }
            result[i] = count;
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(i)), String.valueOf(result[i])));
        }
        return Arrays.toString(result);
    }
}
