package ciphers;

import org.junit.jupiter.api.BeforeAll;


class SimpleShiftTest extends CipherTest{
    @BeforeAll
    public static void init() {
        result = "sdeahp";
        cipher = new SimpleShift();
    }
}