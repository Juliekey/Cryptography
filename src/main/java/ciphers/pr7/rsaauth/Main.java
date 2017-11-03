package ciphers.pr7.rsaauth;

public class Main {
    public static void main(String[] args) {
        GoodClient goodClient = new GoodClient();
        RSAAuthChecker rsaAuthChecker = new RSAAuthChecker();
        boolean authenticated = rsaAuthChecker.authenticate(goodClient);
        System.out.println("K: " + rsaAuthChecker.getKValue());
        System.out.println("Публичный ключ: " + rsaAuthChecker.getRsa().getPublicKey());
        System.out.println("Приватный ключ: " + rsaAuthChecker.getRsa().getSecretKey());
        System.out.println("N: " + rsaAuthChecker.getN());
        System.out.println("R: " + rsaAuthChecker.getR());
        System.out.println("K': " + rsaAuthChecker.getKFromClient());
        if (authenticated) {
            System.out.println("Клиент был успешно аутентифицирован");
        }

    }
}
