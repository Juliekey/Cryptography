package ciphers.pr5;

import entities.Cipher;
import javafx.util.Pair;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class RSA extends Cipher implements Decryptor {
    private BigInteger publicKey;
    private BigInteger secretKey;
    private BigInteger modus;
    private BigInteger phi;
    private static final int BIT_LENGTH = 512;

    public RSA() {
        name = "RSA";
        generateKeys(BIT_LENGTH);
    }

    public void generateKeys(int bitLength) {

        BigInteger p = generatePrime(bitLength / 2);
        BigInteger q = generatePrime(bitLength / 2);
        generateKeys(p, q);

        if (!areKeysNormal(publicKey, secretKey, phi)) {
            generateKeys(bitLength);
        }
    }

    public void generateKeys(BigInteger p, BigInteger q) {

        if (!q.isProbablePrime(25) || !p.isProbablePrime(25))
            throw new IllegalArgumentException("parameters are not equal");

        modus = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        publicKey = getPublicExponent(phi);
        secretKey = getSecretExponent(publicKey, phi);
    }

    private boolean areKeysNormal(BigInteger pKey, BigInteger sKey, BigInteger phi) {
        return BigInteger.ONE.compareTo(pKey.multiply(sKey).mod(phi)) == 0;
    }

    private BigInteger getSecretExponent(BigInteger pExp, BigInteger phi) {

        return pExp.modInverse(phi);
    }

    private BigInteger getPublicExponent(BigInteger phi) {

        BigInteger exp = new BigInteger("3");
        while (phi.gcd(exp).intValue() > 1) {
            exp = exp.add(new BigInteger("2"));
        }
        return exp;
    }

    public BigInteger generatePrime(int bitLength) {
        Random random = new Random();
        BigInteger prime;

        do {
            prime = BigInteger.probablePrime(bitLength, random);
        } while (!prime.isProbablePrime(25));

        return prime;
    }


    @Override
    public String getKey() {
        return "Public key : " + publicKey + ", private key: " + secretKey;
    }

    @Override
    public String decrypt(String word) {
        return encrypt(word, secretKey, modus);
    }

    @Override
    public String encrypt(String word) {
        return encrypt(word, publicKey, modus);
    }

    public String encrypt(String msg, BigInteger pKey, BigInteger m) {
        if (pKey == null
                || m == null
                || m.compareTo(BigInteger.ZERO) == 0
                || pKey.signum() <= 0)
            throw new IllegalArgumentException("you haven't generated keys yet");
        if (msg == null) {
            return null;
        }
        BigInteger message;
        String result;

        try {
            message = new BigInteger(msg.getBytes("ISO-8859-1"));
            if (message.compareTo(m) > 0) {
                throw new IllegalArgumentException("message is too long");
            }
            result = new String(message.modPow(pKey, m).toByteArray(), "ISO-8859-1");
            formTableOfChanges(msg, result);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("can't convert", e);
        }
        return result;

    }

    private void formTableOfChanges(String msg, String result) {
        tableOfChange = new ArrayList<>();
        for (int i = 0, n = msg.length() > result.length() ? result.length() : msg.length(); i < n; i++) {
            tableOfChange.add(new Pair<>(String.valueOf(msg.charAt(i)), String.valueOf(result.charAt(i))));
        }
    }


}
