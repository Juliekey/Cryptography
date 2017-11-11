package ciphers.pr8.rsa;

import java.math.BigInteger;

public class Receiver {
    public boolean receive(String msg, Sender sender, BigInteger signature) {
        BigInteger signHash = signature.modPow(sender.getRsa().getPublicKey(), BigInteger.valueOf(Sender.getN()));
        return BigInteger.valueOf(Sender.getH()).equals(signHash);
    }
}
