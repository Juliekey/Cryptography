package ciphers.pr2;

import ciphers.util.ArraysHelper;
import entities.Cipher;
import javafx.util.Pair;

public class DoubleShift extends Cipher {
    private static final int TABLE_SIZE = 4;
    private static final char REPLACEMENT = '_';

    public DoubleShift() {
        name = "Double Shift";
        key = "table size: " + TABLE_SIZE + ", rows exchanges: 1<->2, 2<->4, columns exchanges: 3<->4, 2<->3, 1<->2";
    }

    @Override
    public String encrypt(String word) {
        Character[][] table = ArraysHelper.fillArrWIthWord(word, TABLE_SIZE, REPLACEMENT);
        ArraysHelper.exchangeRows(table, 0, 1);
        ArraysHelper.exchangeRows(table, 1, 3);
        ArraysHelper.exchangeColumns(table, 2, 3);
        ArraysHelper.exchangeColumns(table, 1, 2);
        ArraysHelper.exchangeColumns(table, 0, 1);
        StringBuffer result = new StringBuffer();
        int wordIndex = 0;
        int n = word.length();
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                char newChar = table[i][j];
                if (wordIndex < n) {
                    tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(wordIndex)), String.valueOf(newChar)));
                    wordIndex++;
                }
                result.append(newChar);

            }
        }
        return result.toString();
    }




}
