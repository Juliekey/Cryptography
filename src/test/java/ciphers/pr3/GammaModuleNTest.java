package ciphers.pr3;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;


class GammaModuleNTest extends CipherTest{
    @BeforeAll
    public static void init() {
        word = "hydrogen peroxide";
        result = "jgsysxgvpwiiqfxki";
        cipher = new GammaModuleN();
    }
}