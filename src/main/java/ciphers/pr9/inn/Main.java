package ciphers.pr9.inn;

import ciphers.pr9.ControlNumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ControlNumber inn = new INN();
        byte[] number = {2, 7, 5, 8, 6, 2, 0, 8, 4, 2};
        System.out.println("INN: " + Arrays.toString(number));
        int result = inn.getControlNumber(number);
        System.out.println("Control number: " + result);
    }
}
