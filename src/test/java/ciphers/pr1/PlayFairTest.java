package ciphers.pr1;

import ciphers.CipherTest;
import ciphers.pr1.PlayFair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PlayFairTest extends CipherTest {

    @BeforeAll
    public static void init() {
        result = "hc fb tp";
        cipher = new PlayFair();
    }

    @Test
    public void testWithRepeatingWords() {
        String word = "pedasshf";
        String result = "hc fb pb tp bz";
        assert cipher.encrypt(word).equals(result);

    }
}