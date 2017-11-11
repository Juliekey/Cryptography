package ciphers.pr8.rsa;

import ciphers.pr5.RSA;
import lombok.Getter;

import java.math.BigInteger;

public class Sender {

    private static final int H = 17;

    public static int getH() {
        return H;
    }

    public static int getN() {
        return N;
    }

    private static final int N = 91;

    @Getter
    RSA rsa = new RSA();

    public boolean send(String msg, Receiver receiver) {
        BigInteger signature = BigInteger.valueOf(H).modPow(rsa.getSecretKey(), BigInteger.valueOf(N));
        return receiver.receive(msg, this, signature);
    }
}
