package ciphers;

import entities.Cipher;
import org.junit.jupiter.api.Test;

public abstract class CipherTest {
    protected static String word = "pedash";
    protected static String result;
    public static Cipher cipher;

    @Test
    public void encryptSurname() {
        String encrypted = cipher.encrypt(word);
//        System.out.println(result);
//        System.out.println(encrypted);
        assert encrypted.equals(result);
    }
}
