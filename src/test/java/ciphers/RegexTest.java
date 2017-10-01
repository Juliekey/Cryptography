package ciphers;

import entities.Cipher;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexTest {
    protected static String word = "pedash";
    protected static String pattern;
    public static Cipher cipher;

    @Test
    public void encryptSurname() {
        String encrypted = cipher.encrypt(word);
        boolean test = false;
        test = Pattern.matches(pattern, encrypted);
        assertTrue(test);

    }
}
