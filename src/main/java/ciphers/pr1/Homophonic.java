package ciphers.pr1;

import ciphers.Cipher;
import ciphers.Constants;

import java.util.Random;

public class Homophonic extends Cipher {

    private static char[][] variants = new char[Constants.EN_ALPHABET_CNT][];
    private static Random rnd = new Random();
    public static  int[] frequency = {8, 1, 2, 4, 12, 2, 2, 6, 7, 0, 1, 4, 2, 7, 7, 2, 0, 6, 6, 9, 3, 1, 2, 0, 2, 0};

    private String shuffle() {
        StringBuffer sb = new StringBuffer(Constants.ALPHABET);
        for (int i = sb.length() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            char a = sb.charAt(index);
            sb.setCharAt(index, sb.charAt(i));
            sb.setCharAt(i, a);
        }
        return sb.toString();
    }
    private void add() {
        String shuffled = shuffle();
        for (int i = 0; i < Constants.EN_ALPHABET_CNT; i++){
            if(frequency[i]>=7){
                variants[i] = new char[2];
            }
            else if(frequency[i]>=10){
                variants[i] = new char[3];
            }
            else{
                variants[i] = new char[1];
            }
            variants[i][0] = shuffled.charAt(i);
            for (int j = 1; j < variants[i].length; j++){
                variants[i][j] = Character.forDigit(rnd.nextInt(9), 10);
            }
        }


    }
    public String encrypt(String word){
        StringBuffer encrypted = new StringBuffer();
        add();
        for (int i = 0, n = word.length(); i < n; i++) {
            char current = word.charAt(i);
            int index = Constants.ALPHABET.indexOf(current);
            char encryptedChar = variants[index][rnd.nextInt(variants[index].length)];
            encrypted.append(encryptedChar);
            tableOfChange.put(String.valueOf(current), String.valueOf(encryptedChar));
        }
        return encrypted.toString();
    }
}
