package ciphers.pr1;

import ciphers.CipherTest;
import ciphers.pr1.Vizhiner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class VizhinerTest extends CipherTest {
    @BeforeAll
    public static void setUp() {
        result = "rmshwy";
        cipher = new Vizhiner();
    }

}