package ciphers;


import org.junit.jupiter.api.BeforeEach;

class PortaTest extends CipherTest {
    @BeforeEach
    void setUp() {
        result = "iyywfo";
        cipher = new Porta();
    }

}