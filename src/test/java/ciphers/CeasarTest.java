package ciphers;

import org.junit.jupiter.api.BeforeAll;

class CeasarTest extends CipherTest{
    @BeforeAll
    public static void init() {
        result = "shgdvk";
        cipher = new Ceasar();
    }
}