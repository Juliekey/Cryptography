package ciphers.pr1;

import ciphers.CipherTest;
import ciphers.pr1.Ceasar;
import org.junit.jupiter.api.BeforeAll;

class CeasarTest extends CipherTest {
    @BeforeAll
    public static void init() {
        result = "shgdvk";
        cipher = new Ceasar();
    }
}