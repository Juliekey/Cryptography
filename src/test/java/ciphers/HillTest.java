package ciphers;

import org.junit.jupiter.api.BeforeAll;

class HillTest extends CipherTest {
    @BeforeAll
    public static void setUp() {
        cipher = new Hill();
        result = "hdx xuv";
//        word = "ACT";
//        result = "poh";
    }

}