package entities;


import javafx.util.Pair;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public abstract class Cipher {

    protected List<Pair<String, String>> tableOfChange = new LinkedList<>();
    @Getter
    protected String key;
    @Getter
    protected String name;

    public List<Pair<String, String>> getTableOfChange() {
        if (tableOfChange.size() == 0) {
            throw new IllegalStateException("Cipher must run encrypt method first");
        }
        return tableOfChange;
    }

    public abstract String encrypt(String word);
}
