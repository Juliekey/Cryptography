package ciphers;

import org.junit.jupiter.api.BeforeAll;

public class HomophonicTest extends RegexTest{
    @BeforeAll
    public static void init() {
        pattern = new String("^[a-z]{1}[a-z0-9]{1}[a-z]{1}[a-z0-9]{1}[a-z]{2}$");
        cipher = new Homophonic();
    }
}
