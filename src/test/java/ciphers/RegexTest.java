package ciphers;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.regex.Pattern;

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
