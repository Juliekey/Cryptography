package ciphers;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class Cipher {
    @Getter
    protected Map<String, String> tableOfChange = new HashMap<>();
    @Getter
    protected static String key;

    public abstract String encrypt(String word);
}
