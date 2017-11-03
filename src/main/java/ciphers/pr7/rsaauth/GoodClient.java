package ciphers.pr7.rsaauth;

import java.math.BigInteger;

public class GoodClient implements RSAClient{

    @Override
    public BigInteger transform(BigInteger number, BigInteger secretKey, BigInteger n) {
        System.out.println(number.modPow(secretKey, n));
        return number.modPow(secretKey, n);
    }
}
