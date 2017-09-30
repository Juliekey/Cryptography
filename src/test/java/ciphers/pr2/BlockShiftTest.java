package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BlockShiftTest extends CipherTest {
    @BeforeAll
    public static void setUp(){
        word = "pedash";
        cipher = new BlockShift();
        result = "dpehas";
    }

}