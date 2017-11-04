package ciphers.pr7.rsaauth;

import java.math.BigInteger;

public class GoodClient implements RSAClient{

    @Override
    public BigInteger transform(BigInteger number, BigInteger secretKey, BigInteger n) {
        return number.modPow(secretKey, n);
    }
}
