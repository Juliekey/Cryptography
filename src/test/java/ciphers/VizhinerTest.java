package ciphers;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class VizhinerTest extends CipherTest {
    @BeforeEach
    void setUp() {
        result = "rmshwy";
        cipher = new Vizhiner();
    }

}