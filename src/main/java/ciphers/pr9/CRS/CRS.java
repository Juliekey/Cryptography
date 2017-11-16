package ciphers.pr9.CRS;

import lombok.Getter;

public class CRS {
    @Getter
    private String controlSum;
    @Getter
    private String quotient;
    @Getter
    private String inputDataWithControlSum;

    public String getControlSum(int n) {
        int xN = 19;
        int fullNumber = Integer.parseInt(Integer.toBinaryString(n) + "0000", 2);
        controlSum = Integer.toBinaryString(fullNumber % xN);
        quotient = Integer.toBinaryString(fullNumber / xN);
        inputDataWithControlSum = Integer.toBinaryString(n) + controlSum;
        return controlSum;
    }
}
