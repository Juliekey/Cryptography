package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;

class MagicSquareTest extends CipherTest {
    @BeforeAll
    public static void setUp() {
        word = "mathematics";
        result = ".ta.ecstima.h..m";
        cipher = new MagicSquare();
    }

}