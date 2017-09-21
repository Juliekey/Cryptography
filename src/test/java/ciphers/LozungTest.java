package ciphers;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LozungTest extends CipherTest {
    @BeforeAll
    public static void init() {
        result = "nehcsb";
        cipher = new Lozung();
    }


}