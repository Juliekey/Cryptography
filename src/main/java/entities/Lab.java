package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
public final class Lab {

    @Getter
    private String name;
    private final Map<Integer, Cipher> ciphers;

    public Map<Integer, Cipher> getCiphers() {
        return Collections.unmodifiableMap(ciphers);
    }
}
