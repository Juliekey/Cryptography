package ciphers;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class CombinedTest extends CipherTest {
    @BeforeAll
    public static void setUp() {
        result = "2 4 12 10 22 3";
        cipher = new Combined();

    }

}