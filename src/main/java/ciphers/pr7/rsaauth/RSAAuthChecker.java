package ciphers.pr7.rsaauth;

import ciphers.pr5.RSA;
import sun.nio.cs.ext.MacHebrew;
import sun.security.mscapi.RSACipher;

import java.math.BigInteger;

public class RSAAuthChecker {
    RSA rsa = new RSA();
    private final static int K_VALUE = 7;
    final BigInteger N = new BigInteger("36");

    public RSA getRsa() {
        return rsa;
    }

    private BigInteger r;
    private BigInteger kFromClient;

    public BigInteger getR() {
        return r;
    }

    public BigInteger getKFromClient() {
        return kFromClient;
    }

    public  int getKValue() {
        return K_VALUE;
    }

    public BigInteger getN() {
        return N;
    }

    private BigInteger getNumberToSendToClient() {
        BigInteger publicKey = rsa.getPublicKey();
        final BigInteger K = new BigInteger(String.valueOf(K_VALUE));//index of first letter of my surname(p) in the alphabet
        r = K.modPow(publicKey, N);
        return r;
    }

    public boolean authenticate(RSAClient rsaClient) {
        BigInteger numberToSendToClient = getNumberToSendToClient();
        kFromClient = rsaClient.transform(numberToSendToClient, rsa.getSecretKey(), N);
        return kFromClient.intValue() == K_VALUE;
    }

}