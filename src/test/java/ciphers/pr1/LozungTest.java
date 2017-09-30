package ciphers.pr1;


import ciphers.CipherTest;
import ciphers.pr1.Lozung;
import org.junit.jupiter.api.BeforeAll;

public class LozungTest extends CipherTest {
    @BeforeAll
    public static void init() {
        result = "nehcsb";
        cipher = new Lozung();
    }


}