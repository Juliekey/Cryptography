package ciphers;


import javafx.util.Pair;
import lombok.Getter;

import java.util.*;

public abstract class Cipher {
    @Getter
    protected List<Pair<String, String>> tableOfChange = new LinkedList<>();
    @Getter
    protected String key;

    public abstract String encrypt(String word);
}
