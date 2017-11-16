package ciphers.pr9.train;

import ciphers.pr9.ControlNumber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ControlNumber inn = new Train();
        byte[] number = {2, 7, 5, 8, 6};
        System.out.println("АСУЖТ: " + Arrays.toString(number));
        int result = inn.getControlNumber(number);
        System.out.println("Control number: " + result);
    }
}
