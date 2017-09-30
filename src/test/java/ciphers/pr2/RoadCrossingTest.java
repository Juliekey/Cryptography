package ciphers.pr2;

import ciphers.CipherTest;
import org.junit.jupiter.api.BeforeAll;

public class RoadCrossingTest extends CipherTest{
    @BeforeAll
    public static void init() {
        word = "hydrogen peroxide";
        result = "yghdoernpx eoird-e--";
        cipher = new RoadCrossing();
    }
}
