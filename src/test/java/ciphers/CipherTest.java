package ciphers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public abstract class CipherTest {
    protected static String word = "pedash";
    protected static String result;
    public static Cipher cipher;

    @Test
    public void encryptSurname() {
        assert cipher.encrypt(word).equals(result);
    }
}
