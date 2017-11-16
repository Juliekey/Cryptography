package ciphers.pr9.ean13;

import ciphers.pr9.ControlNumber;

public class ean13 implements ControlNumber {
    public int getControlNumber(byte[] number) {
        int sumOfRemainingOdd = 0;
        int sumOfEven = 0;
        for (int i = 0, n = number.length; i < n-2; i += 2) {
            sumOfRemainingOdd += number[i];
        }
        for (int i = 1; i < number.length; i += 2) {
            sumOfEven += number[i]*3;
        }
        return 10 - ((sumOfEven + sumOfRemainingOdd) % 10);
    }
}
