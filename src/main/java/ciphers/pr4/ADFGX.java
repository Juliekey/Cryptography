package ciphers.pr4;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class ADFGX extends Cipher{
    char[] header = {'a', 'd', 'f', 'g', 'x'};
    char[][] arr = new char[5][5];
    char[][] arrkey;
    String first;
    TreeMap<Character, String> map;
    Random rnd = new Random();

    public ADFGX(){
        name = "ADFGX";
        key = "cipher";
    }

    private String shuffle() {
        StringBuffer sb = new StringBuffer(Constants.ALPHABET);
        sb.deleteCharAt(Constants.ALPHABET.indexOf('j'));
        for (int i = sb.length() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            char a = sb.charAt(index);
            sb.setCharAt(index, sb.charAt(i));
            sb.setCharAt(i, a);
        }
        return sb.toString();
    }
    void add(String str){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = str.charAt(count);
                count++;
            }
        }
    }
    void firstEncrypt(String word){

        StringBuffer sb = new StringBuffer();
        Boolean find = false;
                for (int k = 0; k < word.length(); k++) {
                    for (int i = 0; i < arr.length; i++){
                        for (int j = 0; j < arr.length; j++){
                            if(arr[i][j]==word.charAt(k)) {
                                sb.append(header[i]);
                                sb.append(header[j]);
                                find = true;
                                break;
                            }
                        }
                        if(find){
                            find = false;
                            break;
                        }
                    }
                }
        first = sb.toString();
    }
    void encryptWithKey(String str){
        int size = (int)Math.ceil((double)str.length()/key.length());
        arrkey = new char[size][key.length()];
        int count = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < key.length() && count < str.length(); j++){
                arrkey[i][j] = str.charAt(count);
                count++;
            }
        }
    }
    void createMap(){
        map = new TreeMap<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arrkey[0].length; i++){
            for(int j = 0; j < arrkey.length; j++){
                sb.append(arrkey[j][i]);
            }
            if(map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), map.get(key.charAt(i))+sb.toString());
            }
            else {
                map.put(key.charAt(i), sb.toString());
            }
            sb.delete(0, sb.length());
        }
    }
    private String deleteEmptyEntries(StringBuffer word){
            int index;
            while((index=word.indexOf(String.valueOf('\u0000')))!=-1||(index=word.indexOf(String.valueOf('\u0020')))!=-1){
                word.deleteCharAt(index);
            }
            return word.toString();
    }
    public String encrypt(String word){
        add(shuffle());
        word = deleteEmptyEntries(new StringBuffer(word));
        firstEncrypt(word);
        encryptWithKey(first);
        createMap();
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character , String> entry : map.entrySet()) {
            sb.append(entry.getValue());
        }
        String result = deleteEmptyEntries(sb);
        for(int k = 0, z = 0; k < word.length(); k++, z+=2){
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(k)),
                    String.valueOf(sb.charAt(z))+String.valueOf(sb.charAt(z+1))));
        }
        return result;
    }
}
