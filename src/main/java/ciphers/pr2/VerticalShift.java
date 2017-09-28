package ciphers.pr2;

import ciphers.Cipher;

public class VerticalShift extends Cipher {
    private static final int[] orderOfCiphering = {0, 4, 3, 1, 2, 5};

    private static final int TABLE_SIZE = orderOfCiphering.length;
    private static final char DEFAULT = '_';

    public VerticalShift() {
        key = "cipher";
    }

    @Override
    public String encrypt(String word) {
        char[][] wordInTable = getTableWithWord(word);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < TABLE_SIZE; i++) {
            int column = orderOfCiphering[i];
            for (int j = 0; j < TABLE_SIZE; j++) {
                result.append(wordInTable[j][column]);
                tableOfChange.put(String.valueOf(wordInTable[i][j]), String.valueOf(wordInTable[j][column]));
            }
        }
        return result.toString();
    }


    private char[][] getTableWithWord(String word) {
        int n = word.length();
        int charIndex = 0;
        char[][] wordInTable = new char[TABLE_SIZE][TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                if (charIndex < n) {
                    wordInTable[i][j] = word.charAt(charIndex);
                    charIndex++;
                } else {
                    wordInTable[i][j] = DEFAULT;
                }
            }

        }
        return wordInTable;
    }
}
