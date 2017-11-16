package ciphers.pr9.train;

import ciphers.pr9.ControlNumber;

public class Train implements ControlNumber {
    @Override
    public int getControlNumber(byte[] number) {
        int length = number.length;
        if (length != 5) {
            throw new IllegalArgumentException("should contain 5 numbers!");
        }
        int sum = (number[0] + 2 * number[1] + 3 * number[2] + 4 * number[3] + 5 * number[4] ) % 11;
        if(sum == 10){
            sum = 0;
        }
        return sum;
    }
}
