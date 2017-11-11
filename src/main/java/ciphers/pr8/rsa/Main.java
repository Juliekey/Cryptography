package ciphers.pr8.rsa;

public class Main {

    public static void main(String[] args) {
        Sender sender = new Sender();
        boolean result = sender.send("hello", new Receiver());
        System.out.println("h: " + Sender.getH());
        System.out.println("n: " + Sender.getN());
        System.out.println("Private key: " + sender.getRsa().getSecretKey());
        System.out.println("Public key: " + sender.getRsa().getPublicKey());
        System.out.println(result);
    }
}
