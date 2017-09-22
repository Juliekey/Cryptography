package ciphers;

import java.util.Random;

public class Homophonic extends Cipher {

    private static String chars = "abcdefghijklmnopqrstuvwxyz";
    private static char[][] variants = new char[Constants.EN_ALPHABET_CNT][];
    private static Random rnd = new Random();

    private String shuffle() {
        StringBuffer sb = new StringBuffer(chars);
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
            if(Constants.FREQUENCY[i]>=7){
                variants[i] = new char[2];
            }
            else if(Constants.FREQUENCY[i]>=10){
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
        for (int i = 0, n = word.length(); i < n; i++) {
            char current = word.charAt(i);
            int index = chars.indexOf(current);
            char encryptedChar = variants[index][rnd.nextInt(variants.length)];
            encrypted.append(encryptedChar);
            tableOfChange.put(String.valueOf(current), String.valueOf(encryptedChar));
        }
        return encrypted.toString();
    }
}
