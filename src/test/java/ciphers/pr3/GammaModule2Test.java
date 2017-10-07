package ciphers.pr3;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class GammaModule2Test extends CipherTest{
    @BeforeAll
    public static void init() {
        word = "hydrogen peroxide";
        result = "kptzjufg°x``lqyl`";
        cipher = new GammaModule2();
    }
}