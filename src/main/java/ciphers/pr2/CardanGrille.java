package ciphers.pr2;

import ciphers.Cipher;
import ciphers.Constants;
import ciphers.util.ArraysHelper;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class CardanGrille extends Cipher {
    Integer[][] grille = {{0, 1, 0, 1}, {1, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}};
    private static final int TABLE_SIZE = 4;

    public CardanGrille() {
        key = Arrays.deepToString(grille);
    }

    @Override
    public String encrypt(String word) {
        Integer[][] currGrill = ArraysHelper.deepCopy(grille);
        char[][] ciphered = new char[TABLE_SIZE][TABLE_SIZE];
        int index = 0;
        int n = word.length();
        index = putLettersAccordingToGrill(ciphered, currGrill, word, index);
        if (index >= n) {
            return getWordFromTable(ciphered, word);
        }
        mirror(currGrill);
        index = putLettersAccordingToGrill(ciphered, currGrill, word, index);
        if (index >= n) {
            return getWordFromTable(ciphered, word);
        }
        turn180degrees(currGrill);
        index = putLettersAccordingToGrill(ciphered, currGrill, word, index);
        if (index >= n) {
            return getWordFromTable(ciphered, word);
        }
        mirror(currGrill);
        index = putLettersAccordingToGrill(ciphered, currGrill, word, index);
        if (index >= n) {
            return getWordFromTable(ciphered, word);
        }
        return getWordFromTable(ciphered, word);

    }

    private String getWordFromTable(char[][] ciphered, String word) {
        StringBuffer result = new StringBuffer();
        Character[][] original = ArraysHelper.fillArrWIthWord(word, TABLE_SIZE, Constants.SPACE);
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                char newChar = ciphered[i][j];
                if (newChar == Constants.DEFAULT_CHAR_VALUE) {
                    newChar = (char) (random.nextInt(Constants.EN_ALPHABET_CNT) + Constants.LC_A_ASCII_INDEX);
                }
                result.append(newChar);
                tableOfChange.add(new Pair<String, String>(String.valueOf(original[i][j]), String.valueOf(newChar)));
            }
        }
        return result.toString();
    }

    private void turn180degrees(Integer[][] currGrill) {
        for (int i = 0, j = TABLE_SIZE - 1; i < TABLE_SIZE / 2; i++, j--) {
            ArraysHelper.exchangeRows(currGrill, i, j);
        }
    }

    private void mirror(Integer[][] currGrill) {
        for (int i = 0, j = TABLE_SIZE - 1; i < TABLE_SIZE / 2; i++, j--) {
            ArraysHelper.exchangeColumns(currGrill, i, j);
        }
    }


    public int putLettersAccordingToGrill(char[][] ciphered, Integer[][] currGrill, String word, int index) {
        for (int i = 0, len = word.length(); i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE && index < len; j++) {
                if (currGrill[i][j] == 0) {
                    ciphered[i][j] = word.charAt(index);
                    index++;
                }
            }
        }
        return index;
    }


}
