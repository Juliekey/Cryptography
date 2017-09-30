package ciphers.util;

public class ArraysHelper {
    public static Character[][] fillArrWIthWord(String word, int tableSize, char replacement) {
        Character[][] table = new Character[tableSize][tableSize];
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

    public static Integer[][] deepCopy(Integer[][] arr) {
        Integer[][] newArr = new Integer[arr.length][];
        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[i].clone();
        return newArr;
    }

    public static <T> void exchangeColumns(T[][] table, int c1, int c2) {
        for (int j = 0; j < table[0].length; j++) {
            T temp = table[j][c1];
            table[j][c1] = table[j][c2];
            table[j][c2] = temp;
        }
    }

    public static <T> void exchangeRows(T[][] table, int r1, int r2) {
        for (int j = 0; j < table.length; j++) {
            T temp = table[r1][j];
            table[r1][j] = table[r2][j];
            table[r2][j] = temp;
        }

    }

}
