package ciphers;


import org.junit.jupiter.api.BeforeAll;

class PolybiusSquareTest extends CipherTest {

    @BeforeAll
    public static void init() {
        result = "35 15 14 11 43 23";
        cipher = new PolybiusSquare();
    }
}