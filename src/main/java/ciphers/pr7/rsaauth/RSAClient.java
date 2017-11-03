package ciphers.pr7.rsaauth;

import java.math.BigInteger;

public interface RSAClient {

    BigInteger transform(BigInteger number, BigInteger secretKey, BigInteger n);
}
