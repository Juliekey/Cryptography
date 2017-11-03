package ciphers.pr7.rsaauth;

import java.math.BigInteger;

public class BadClient implements RSAClient {
    @Override
    public BigInteger transform(BigInteger number, BigInteger secretKey, BigInteger n) {
        return new BigInteger("-4124141");
    }
}
