package ciphers.pr1;

import ciphers.CipherTest;
import ciphers.pr1.Combined;
import org.junit.jupiter.api.BeforeAll;

class CombinedTest extends CipherTest {
    @BeforeAll
    public static void setUp() {
        result = "2 4 12 10 22 3";
        cipher = new Combined();

    }

}