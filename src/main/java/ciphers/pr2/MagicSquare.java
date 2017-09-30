package ciphers.pr2;

import ciphers.Cipher;
import javafx.util.Pair;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MagicSquare extends Cipher {
    private final static int[][] MAGIC_SQUARE = {{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}};
    private static Map<Integer, Point> coordinates = new HashMap<>();
    private static final int SQUARE_SIZE = 4;
    private static final char REPLACEMENT = '.';
    private static final char DEFAULT_CHAR_VALUE = '\u0000';

    public MagicSquare() {
        key = Arrays.deepToString(MAGIC_SQUARE);
        formLettersCoordinatesMap();
    }

    public void formLettersCoordinatesMap() {
        for (int i = 0; i < SQUARE_SIZE; i++) {
            for (int j = 0; j < SQUARE_SIZE; j++) {
                coordinates.put(MAGIC_SQUARE[i][j] - 1, new Point(i, j));
            }
        }
    }

    @Override
    public String encrypt(String word) {
        char[][] writtenWord = new char[SQUARE_SIZE][SQUARE_SIZE];
        StringBuilder result = new StringBuilder();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            Point point = coordinates.get(i);
            writtenWord[(int) point.getX()][(int) point.getY()] = word.charAt(i);
        }
        int wordLetterIndex = 0;
        for (int i = 0; i < SQUARE_SIZE; i++) {
            for (int j = 0; j < SQUARE_SIZE; j++) {
                char newChar = writtenWord[i][j];
                if (newChar != DEFAULT_CHAR_VALUE) {
                    tableOfChange.add(new Pair<String, String>(String.valueOf(word.charAt(wordLetterIndex)), String.valueOf(newChar)));
                    wordLetterIndex++;
                    result.append(newChar);
                } else {
                    result.append(REPLACEMENT);
                }
            }
        }
        return result.toString();

    }
}
