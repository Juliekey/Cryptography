package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;

class VerticalShiftTest extends CipherTest {
    @BeforeAll
    public static void setUp() {
        word = "London is a capital of GB";
        result = "L clB_oat __d if__oia __nspo__n aG__";

        cipher = new VerticalShift();
    }

}