package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CipherObject {
    @Getter
    private String name;
    @Getter
    Cipher cipher;
}
