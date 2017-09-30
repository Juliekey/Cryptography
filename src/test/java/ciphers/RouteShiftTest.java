package ciphers;

import org.junit.jupiter.api.BeforeAll;


class RouteShiftTest extends CipherTest{

    @BeforeAll
    public static void init() {
        result = "hgedyeredno r x opi ";
        cipher = new RouteShift();
    }
}