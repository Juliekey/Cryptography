package ciphers.pr1;


import ciphers.CipherTest;
import ciphers.pr1.Porta;
import org.junit.jupiter.api.BeforeEach;

class PortaTest extends CipherTest {
    @BeforeEach
    void setUp() {
        result = "iyywfo";
        cipher = new Porta();
    }

}