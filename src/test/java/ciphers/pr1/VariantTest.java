package ciphers.pr1;

import ciphers.RegexTest;
import ciphers.pr1.Variant;
import org.junit.jupiter.api.BeforeAll;

class VariantTest extends RegexTest {
    @BeforeAll
    public static void init() {
        pattern = new String("^(d|f)(t|y)(d|f)(o|p)(g|h)(t|y)(g|h)(q|w)(l|z)(q|w)(d|f)(u|i)$");
        cipher = new Variant();
    }
}