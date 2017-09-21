package ciphers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrisemusSystemTest extends CipherTest {
    @BeforeAll
    public static void init() {
        word = "педаш";
        cipher = new TrisemusSystem();
        result = "щглжю";
    }

}