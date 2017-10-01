package entities;


import javafx.util.Pair;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public abstract class Cipher {
    @Getter
    protected List<Pair<String, String>> tableOfChange = new LinkedList<>();
    @Getter
    protected String key;
    @Getter
    protected String name;


    public abstract String encrypt(String word);
}
