package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;

class DoubleShiftTest extends CipherTest {
    @BeforeAll
    static void setUp() {
        word = "mathematics";
        result = "tema_____icshmat";

        cipher = new DoubleShift();
    }

}