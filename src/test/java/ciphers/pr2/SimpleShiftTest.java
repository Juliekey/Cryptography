package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;


class SimpleShiftTest extends CipherTest {
    @BeforeAll
    public static void init() {
        result = "sdeahp";
        cipher = new SimpleShift();
    }
}