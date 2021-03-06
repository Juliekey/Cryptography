package ciphers.pr1;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

public class Hill extends Cipher {

    private static final int SIZE = 3;


    private int[][] keyMatrix = {{6, 24, 1}, {13, 16, 10}, {20, 17, 15}};

    public Hill() {
        name = "Hill";
        key = "gybnqkurp";
    }

    @Override
    public String encrypt(String word) {
        word = word.toLowerCase();
        StringBuffer result = new StringBuffer();
        int n = word.length();
        for (int i = 0; i < n; ) {
            if (i + SIZE <= n) {
                result.append((encryptSubstring(word.substring(i, i + SIZE))));
            } else {
                result.append(encryptSubstring(word.substring(i)));
            }
            i += SIZE;
            if (i < n) {
                result.append(Constants.SPACE);
            }
        }
        return result.toString();
    }

    private String encryptSubstring(String substring) {
        StringBuffer result = new StringBuffer();
        int[] vector = transformStringToVector(substring);
        int[] hillVector = multiply(keyMatrix, vector);
        for (int i = 0, n = hillVector.length; i < n; i++) {
            char encryptedChar = (char) (hillVector[i] + Constants.LC_A_ASCII_INDEX);
            result.append(encryptedChar);
            tableOfChange.add(new Pair<String, String>(String.valueOf(substring.charAt(i)), String.valueOf(encryptedChar)));
        }
        return result.toString();
    }

    private int[] multiply(int[][] matrix, int[] vector) {
        int vectorSize = vector.length;
        int[] result = new int[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            for (int j = 0; j < vectorSize; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
            result[i] = result[i] % Constants.EN_ALPHABET_CNT;

        }
        return result;
    }

    private int[] transformStringToVector(String word) {
        int length = word.length();
        int[] vector = new int[length];
        for (int i = 0; i < length; i++) {
            vector[i] = word.charAt(i) % Constants.LC_A_ASCII_INDEX;
        }
        return vector;
    }
}
