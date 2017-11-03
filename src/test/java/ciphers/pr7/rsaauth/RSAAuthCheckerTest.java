package ciphers.pr7.rsaauth;

import org.junit.jupiter.api.Test;

class RSAAuthCheckerTest {
    RSAAuthChecker rsaAuthChecker = new RSAAuthChecker();

    @Test
    void authenticateGoodClient() {
        assert rsaAuthChecker.authenticate(new GoodClient());
    }

    @Test
    void authenticateBadClient() {
        assert !rsaAuthChecker.authenticate(new BadClient());
    }
}