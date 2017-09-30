package ciphers.pr1;

import ciphers.CipherTest;
import ciphers.pr1.Hill;
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