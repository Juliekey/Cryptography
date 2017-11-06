package ciphers.pr5;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.IntStream;

public class Knapsack extends Cipher{
    static int[] weight = {2, 5, 8, 21, 40, 92, 174};
    static Random rnd = new Random();
    static int n = Constants.PRIME[rnd.nextInt(Constants.PRIME.length)-1];
    static int m = rnd.nextInt(100)+IntStream.of(weight).sum();
    static int[] result;
    String binary;
    Map<Integer, ArrayList<Integer>> map;
    ArrayList<Integer> temp;
    String[] binaryarr;

    public Knapsack(){
        name = "Knapsack";
        key = getKey();
    }
    static int[] openKey() {
        int[] openkey = new int[weight.length];
        for (int i = 0; i < openkey.length; i++) {
            openkey[i] = weight[i]*n%m;
        }
        return openkey;
    }
    static int reversed(){
        int j=0;
        for(int i=0; i<m; i++){
            if((n*i) % m==1) {
                j=i; break;
            }
        }
        return j;
    }

    @Override
    public String getKey() {
        return "Public key : " + Arrays.toString(openKey()) + ", private key: " + Arrays.toString(weight);
    }

    @Override
    public String encrypt(String word) {
        result = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            int count = 0;
            binary = Integer.toBinaryString(word.charAt(i));
            for(int j = 0; j < binary.length(); j++){
                if(binary.charAt(j)=='1'){
                    count += openKey()[j];
                }
            }
            result[i] = count;
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(i)), String.valueOf(result[i])));
        }
        return Arrays.toString(result);
    }


    public String decrypt() {
        int[] temp = new int[result.length];
        for(int i = 0; i < result.length; i++) {
            temp[i] = result[i]*reversed()%m;
        }
        createKnapsack(temp);
        createBinary();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < binaryarr.length; i++) {
            int truevalue = Integer.parseInt(binaryarr[i], 2);
            sb.append((char) truevalue);
        }
        return sb.toString();
    }
    private void createKnapsack(int[] arr){
        map = new TreeMap<>();
        for(int i = 0; i < arr.length; i++) {
            int value = arr[i];
            temp = new ArrayList();
            for(int j = weight.length-1; value != 0 && j >= 0; j--) {
                if(value>=weight[j]){
                    temp.add(weight[j]);
                    value -= weight[j];
                }
            }
            map.put(i, temp);
        }
    }
    private void createBinary(){
        StringBuffer sb = new StringBuffer("0000000");
        binaryarr = new String[result.length];
        for(int i = 0; i < map.size(); i++){
            temp = map.get(i);
            for(int j = 0; j < temp.size(); j++){
                for(int k = 0; k < weight.length; k++){
                    if(temp.get(j)==weight[k]){
                        sb.setCharAt(k, '1');
                    }
                }
            }
            binaryarr[i] = sb.toString();
            sb.replace(0, sb.length(),"0000000");
        }
    }
}
