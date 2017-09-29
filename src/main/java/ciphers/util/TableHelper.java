package ciphers.util;

public class TableHelper {
    public static char[][] fillTableWithWord(String word, int tableSize, char replacement) {
        char[][] table = new char[tableSize][tableSize];
        int n = word.length();
        int wordIndex = 0;
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (wordIndex < n) {
                    table[i][j] = word.charAt(wordIndex);
                    wordIndex++;
                } else {
                    table[i][j] = replacement;
                }
            }
        }
        return table;
    }
}
