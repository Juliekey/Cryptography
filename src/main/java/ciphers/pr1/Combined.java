package ciphers.pr1;

import ciphers.Cipher;
import ciphers.Constants;

public class Combined extends Cipher {
    private final static char[][] chars =
            {{'c', 'i', 'p', 'h', 'e', 'r',},
                    {'a', 'b', 'd', 'f', 'g', 'h', 'k', 'l', 'm', 'n'},
                    {'o', 'q', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}};

    public Combined() {
        key = "cipher";
    }

    @Override
    public String encrypt(String word) {
        StringBuffer result = new StringBuffer();
        for (int i = 0, n1 = word.length(); i < n1; i++) {
            char currentChar = word.charAt(i);
            CharSequence currCharCharSeq = String.valueOf(word.charAt(i));
            String newChar = "";
            if (key.contains(currCharCharSeq)) {
                for (int j = 0; j < chars[0].length; j++) {
                    if (chars[0][j] == currentChar) {
                        newChar = String.valueOf(j);
                        break;
                    }
                }
            } else {
                for (int j = 1, n2 = chars.length; j < n2; j++) {
                    boolean isFound = false;
                    for (int k = 0, n3 = chars[1].length; k < n3; k++) {
                        if (chars[j][k] == currentChar) {
                            newChar = String.valueOf(j) + String.valueOf(k);
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound) {
                        break;
                    }
                }
            }
            result.append(newChar);
            result.append(Constants.SPACE);
            tableOfChange.put(String.valueOf(currentChar), newChar);
        }
        System.out.println(result);
        return result.toString().trim();
    }
}
