package ciphers.pr9.ean13;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ean13 e = new ean13();
        byte[] number = {2, 7, 5, 8, 6, 2, 0, 8, 4, 2, 0, 0, 0, 2, 1, 3};
        int result = e.getControlNumber(number);
        System.out.println("Code: "+ Arrays.toString(number));
        System.out.println("Control number: "+result);
    }
}
