package ciphers.pr5;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

import java.math.BigInteger;
import java.util.*;

public class Elgamal extends Cipher{
    static Random rnd = new Random();
    static int p =37;
    static int g = primeRoot(p);
    static int x = rnd.nextInt(p);
    static int y = (int) Math.pow(g, x)%p;
    static int[] arr = {p, g, y};
    int[] values;
    int[] result;
    int a;

    public Elgamal(){
        name = "El Gamal";
        key = getKey();
    }

    private static boolean isPrime(int p) {
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, Integer> getPrimeFactor(int p) {
        Map<Integer, Integer> map = new HashMap<>();
        while (p % 2 == 0) {
            insertToMap(2, map);
            p /= 2;
        }

        for (int i = 3; i <= Math.sqrt(p); i += 2) {
            while (p % i == 0) {
                insertToMap(i, map);
                p /= i;
            }
        }

        if (p > 2)
            insertToMap(p, map);
        return map;
    }

    private static void insertToMap(int i, Map<Integer, Integer> map) {
        if (map.get(i) != null) {
            map.put(i, map.get(i) + 1);
        } else {
            map.put(i, 1);
        }
    }
    private static int primeRoot(int p){
        int m = p;
        if (isPrime(p)) {
            m = p - 1;
        }
        int primeRoot = 0;
        Map<Integer, Integer> primeFactor = getPrimeFactor(m);
        for (Map.Entry<Integer, Integer> map : primeFactor.entrySet()) {
            primeFactor.put(map.getKey(), m / map.getKey());
        }
        for (int i = 2; i <= m; i++) {
            boolean notPrimeRoot = false;
            Set<Integer> reminder = new HashSet<>();
            for (Map.Entry<Integer, Integer> map : primeFactor.entrySet()) {
                if(BigInteger.valueOf(i).modPow(BigInteger.valueOf(map.getValue()), BigInteger.valueOf(p)).equals(BigInteger.ONE))
                    notPrimeRoot = true;
            }
            if (!notPrimeRoot) {
                primeRoot = i;
                break;
            }
        }
        return primeRoot;
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

    @Override
    public String getKey() {
        return "Public key : " + Arrays.toString(arr) + ", private key: " + String.valueOf(x);
    }

    @Override
    public String encrypt(String word) {
        Random rand = new Random();
        values = createOrder(word);
        result = new int[word.length()];
        int k = rand.nextInt(p-2)+1;
        a = (int)Math.pow(g,k)%p;
        for(int i = 0; i < values.length; i++) {
            long pow = (long) Math.pow(y,k);
            BigInteger val = BigInteger.valueOf(pow*values[i]);
            result[i] = val.mod(BigInteger.valueOf(p)).intValue();
            //result[i] = (int)Math.pow(y,k)*values[i]%p;
            tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(i)), String.valueOf(result[i])));
        }
        return Arrays.toString(result);
    }
    public String decrypt() {
        StringBuffer sb = new StringBuffer();
        int value;
        for(int i = 0; i < result.length; i++) {
            value = result[i]*(int)Math.pow(a, p-1-x)%p;
            sb.append(Constants.ALPHABET.charAt(value));
        }
        return sb.toString();
    }
}

