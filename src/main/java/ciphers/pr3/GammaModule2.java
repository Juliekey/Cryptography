package ciphers.pr3;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

public class GammaModule2 extends Cipher{
    String[] binary1;
    String[] binary2;
    int[] result;
    StringBuffer sb;

    public GammaModule2(){
        name = "Gamma Module 2";
        key = "cipher";
    }

    private String createKey(String key, String word){
        sb = new StringBuffer();
        int count = 0;
        while(count<word.length()) {
            for (int i = 0; i < key.length() && count<word.length(); i++) {
                sb.append(key.charAt(i));
                count++;
            }
        }
        return sb.toString();
    }
    public String encrypt(String word) {
        String new_key = createKey(key, word);
        sb.delete(0, sb.length());
        binary1 = new String[word.length()];
        binary2 = new String[new_key.length()];
        result = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            binary1[i] = Integer.toBinaryString(word.charAt(i));
            binary2[i] = Integer.toBinaryString(new_key.charAt(i));
            result[i] = Integer.parseInt(binary1[i], 2)^Integer.parseInt(binary2[i], 2);
            sb.append((char)('a'+(result[i]-1)));
        }
        for (int k = 0; k < sb.length(); k++) {
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(k)), String.valueOf(sb.charAt(k))));
        }
        return sb.toString();
    }
}
