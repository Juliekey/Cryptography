package ciphers.pr9.luna;

import ciphers.pr9.ControlNumber;

public class Luna implements ControlNumber {
    public int getControlNumber(byte[] number) {
        int sumOfRemainingOdd = 0;
        int sumOfEven = 0;
        for (int i = 0, n = number.length; i < n; i += 2) {
            sumOfRemainingOdd += (number[i] * 2) % 9;
        }
        for (int i = 1; i < number.length - 2; i += 2) {
            sumOfEven += number[i];
        }
        return 10 - ((sumOfEven + sumOfRemainingOdd) % 10);
    }
}
