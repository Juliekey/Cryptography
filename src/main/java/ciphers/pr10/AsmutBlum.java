package ciphers.pr10;

import ciphers.Constants;

import java.util.Arrays;
import java.util.Random;

public class AsmutBlum {
    static Random rnd;
    static int[] k, numbers;
    static int p = 37;
    public static void main(String[] args) {

        encrypt("p");
        System.out.println(decrypt());
    }
    public static void encrypt(String word) {
        rnd = new Random();
        for(int i = 0; i < word.length(); i++){
            int order = Constants.ALPHABET.indexOf(word.charAt(i));
            numbers = Arrays.copyOfRange(Constants.PRIME, Arrays.binarySearch(Constants.PRIME, p)+1,
                    Arrays.binarySearch(Constants.PRIME, p)+6);
            int s = calculateS(order, p, numbers);
            k = new int[numbers.length];
            calculateK(s, numbers, k);
            System.out.println("p="+p);
            System.out.println("d="+Arrays.toString(numbers));
            System.out.println("k="+Arrays.toString(k));
            }

        }
    public static int getPrime(int bound){
         rnd = new Random();
        int prime;
        do{
            prime = Constants.PRIME[rnd.nextInt(Constants.PRIME.length)];
        }
        while (prime<bound);
        return prime;
    }

    public static int calculateS(int secret, int prime, int[] numbers){
        int mult = 1;
        rnd = new Random();
        for(int i = 0; i < 3; i++){
            mult *= numbers[i];
        }
        int bound = (mult-secret)/prime;
        int r = rnd.nextInt(bound);
        return secret+r*prime;
    }
    public static void calculateK(int s, int[] numbers, int[] k){
        for(int i = 0; i < numbers.length; i++){
            k[i] = s%numbers[i];
        }
    }
    public static int decrypt(){
        int[] d = new int[3];
        int[] d1 = new int[3];
        int sum = 0;
        int mult = numbers[0]* numbers[1]*numbers[2];
        for(int i = 0; i < 3; i++){
            d[i] = mult/numbers[i];
            d1[i] = extended_gcd(d[i], numbers[i]);
            sum += k[i]*d[i]*d1[i];
        }
        return (sum%mult)%p;
    }
    public static int extended_gcd(int a, int b){
        a %= b;
        for (int x = 1; x < b; x++) {
            if ((a*x)%b == 1) {
                return x;
            }
        }
        return -1;
    }
}
