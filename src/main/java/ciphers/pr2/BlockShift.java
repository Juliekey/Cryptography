package ciphers.pr2;

import ciphers.Constants;
import entities.Cipher;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockShift extends Cipher {
    private static final int[] BLOCK_OF_CHANGES = {1, 2, 0};
    private static final int BLOCK_SIZE = BLOCK_OF_CHANGES.length;

    public BlockShift() {
        name = "Block Shift";
        key = Arrays.toString(BLOCK_OF_CHANGES);
    }

    @Override
    public String encrypt(String word) {
        Integer n = word.length();
        StringBuffer result = new StringBuffer(word);
        for (int i = 0; i < n; i += BLOCK_SIZE) {
            if (i + BLOCK_SIZE > n) {
                Random random = ThreadLocalRandom.current();
                int diff = (i + BLOCK_SIZE) - n;
                for (int j = 0; j < diff; j++) {
                    result.append((char) (random.nextInt(Constants.EN_ALPHABET_CNT) + Constants.LC_A_ASCII_INDEX));
                }
            }
            String original = result.substring(i, i + BLOCK_SIZE);
            for (int j = 0; j < BLOCK_SIZE; j++) {
                int indexOfReplacedChar = i + BLOCK_OF_CHANGES[j];
                String newSymbol = String.valueOf(original.charAt(j));
                tableOfChange.add(new Pair<String, String>(String.valueOf(original.charAt(BLOCK_OF_CHANGES[j])), newSymbol));
                result.replace(indexOfReplacedChar, indexOfReplacedChar + 1, newSymbol);
            }
        }
        return result.toString();
    }
}
