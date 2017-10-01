package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
public final class Lab {

    @Getter
    private String name;
    @Getter
    private final Map<Integer, Cipher> ciphers;
}
