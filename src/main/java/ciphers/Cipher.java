package ciphers;


import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Cipher {
    @Getter
    protected Map<String, String> tableOfChange = new LinkedHashMap<>();
    @Getter
    protected String key;

    public abstract String encrypt(String word);
}
