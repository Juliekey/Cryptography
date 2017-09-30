package ciphers.pr2;

import ciphers.Cipher;
import ciphers.util.ArraysHelper;
import javafx.util.Pair;

public class VerticalShift extends Cipher {
    private static final int[] orderOfCiphering = {0, 4, 3, 1, 2, 5};

    private static final int TABLE_SIZE = orderOfCiphering.length;
    private static final char DEFAULT = '_';

    public VerticalShift() {
        key = "cipher";
    }

    @Override
    public String encrypt(String word) {
        Character[][] wordInTable = ArraysHelper.fillArrWIthWord(word, TABLE_SIZE, DEFAULT);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < TABLE_SIZE; i++) {
            int column = orderOfCiphering[i];
            for (int j = 0; j < TABLE_SIZE; j++) {
                result.append(wordInTable[j][column]);
                tableOfChange.add(new Pair<String, String>(String.valueOf(wordInTable[i][j]), String.valueOf(wordInTable[j][column])));
            }
        }
        return result.toString();
    }


}
