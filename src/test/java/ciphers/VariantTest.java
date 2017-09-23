package ciphers;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class VariantTest extends RegexTest{
    @BeforeAll
    public static void init() {
        pattern = new String("^(d|f)(t|y)(d|f)(o|p)(g|h)(t|y)(g|h)(q|w)(l|z)(q|w)(d|f)(u|i)$");
        cipher = new Variant();
    }
}