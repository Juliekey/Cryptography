package ciphers.pr2;

import ciphers.Cipher;
import ciphers.util.TableHelper;

public class DoubleShift extends Cipher {
    private static final int TABLE_SIZE = 4;
    private static final char REPLACEMENT = '_';

    public DoubleShift() {
        key = "table size: " + TABLE_SIZE + ", rows exchanges: 1<->2, 2<->4, columns exchanges: 3<->4, 2<->3, 1<->2";
    }

    @Override
    public String encrypt(String word) {
        char[][] table = TableHelper.fillTableWithWord(word, TABLE_SIZE, REPLACEMENT);
        exchangeRows(table, 0, 1);
        exchangeRows(table, 1, 3);
        exchangeColumns(table, 2, 3);
        exchangeColumns(table, 1, 2);
        exchangeColumns(table, 0, 1);
        StringBuffer result = new StringBuffer();
        int wordIndex = 0;
        int n = word.length();
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                char newChar = table[i][j];
                if (wordIndex < n) {
                    tableOfChange.put(String.valueOf(word.charAt(wordIndex)), String.valueOf(newChar));
                    wordIndex++;
                }
                result.append(newChar);

            }
        }
        return result.toString();
    }

    private void exchangeColumns(char[][] table, int c1, int c2) {
        for (int j = 0; j < TABLE_SIZE; j++) {
            char temp = table[j][c1];
            table[j][c1] = table[j][c2];
            table[j][c2] = temp;
        }
    }

    private void exchangeRows(char[][] table, int r1, int r2) {
        for (int j = 0; j < TABLE_SIZE; j++) {
            char temp = table[r1][j];
            table[r1][j] = table[r2][j];
            table[r2][j] = temp;
        }

    }
}
