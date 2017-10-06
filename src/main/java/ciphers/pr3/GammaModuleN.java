package ciphers.pr3;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

public class GammaModuleN extends Cipher {
    int[] order1;
    int[] order2;
    int[] result;
    StringBuffer sb;

    public GammaModuleN(){
        name = "Gamma Module N";
        key ="cipher";
    }
    private int[] createOrder(String word){
        int[] order = new int[word.length()];
        for(int i = 0; i < word.length(); i++) {
            for (int j = 0; j < Constants.ALPHABET.length(); j++){
                if(word.charAt(i)==Constants.ALPHABET.charAt(j)){
                    order[i] = j;
                }
                else if(word.charAt(i)==' '){
                    order[i] = Constants.EN_ALPHABET_CNT;
                }
            }
        }
        return order;
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
        order1 = createOrder(word);
        order2 = createOrder(createKey(key, word));
        sb.delete(0, sb.length());
        for(int i = 0; i < order1.length; i++) {
            sb.append(Constants.ALPHABET.charAt((order1[i]+order2[i])%Constants.EN_ALPHABET_CNT));
        }
        for (int k = 0; k < sb.length(); k++) {
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(k)), String.valueOf(sb.charAt(k))));
        }
        return sb.toString();
    }
}
