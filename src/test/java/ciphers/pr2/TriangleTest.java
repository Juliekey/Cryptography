package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;


class TriangleTest extends CipherTest{
    @BeforeAll
    public static void init() {
        word = "hydrogen peroxide";
        result = "dd _yn__rriegxeep_hoo";
        cipher = new Triangle();
    }
}