package ciphers.pr1;

import ciphers.CipherTest;
import ciphers.pr1.TrisemusSystem;
import org.junit.jupiter.api.BeforeAll;

class TrisemusSystemTest extends CipherTest {
    @BeforeAll
    public static void init() {
        word = "педаш";
        cipher = new TrisemusSystem();
        result = "щглжю";
    }

}