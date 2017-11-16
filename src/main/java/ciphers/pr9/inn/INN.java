package ciphers.pr9.inn;

import ciphers.pr9.ControlNumber;

public class INN implements ControlNumber {
    @Override
    public int getControlNumber(byte[] number) {
        int length = number.length;
        if (length != 10) {
            throw new IllegalArgumentException("INN should contain 10 numbers!");
        }
        int sum = ((2 * number[0] + 4 * number[1] + 10 * number[2] + 3 * number[3] + 5 * number[4] + 9 * number[5] +
                4 * number[6] + 6 * number[7] + 8 * number[8]) % 11) % 10;
        return sum;
    }
}
