package ciphers.pr1;

import ciphers.Cipher;
import ciphers.Constants;
import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayFair extends Cipher {
    public final static int SIZE = 5;
    public final static char[][] chars =
            {{'c', 'i', 'p', 'h', 'e'},
                    {'r', 'a', 'b', 'd', 'f'},
                    {'g', 'k', 'l', 'm', 'n'},
                    {'o', 'q', 's', 't', 'u'},
                    {'v', 'w', 'x', 'y', 'z'}};
    public static final char REPLACEMENT = 'x';

    public PlayFair() {
        key = "cipher";
    }

    public String encrypt(String word) {
        List<Pair<Character, Character>> pairs = splitToPairs(word);
        StringBuffer result = new StringBuffer();
        for (Pair<Character, Character> pair :
                pairs) {
            Point p1 = getCoordinatesOfLetter(pair.getKey());
            Point p2 = getCoordinatesOfLetter(pair.getValue());
            char newChar2;
            char newChar1;

            if (p1.getX() == p2.getX()) {
                int x = (int) p1.getX();
                if (Math.abs(p2.getY() - p1.getY()) == 1) {
                    newChar1 = chars[x][(int) ((p1.getY() + 2) % SIZE)];
                    newChar2 = chars[x][(int) ((p2.getY() + 2) % SIZE)];
                    ;
                } else {
                    newChar1 = chars[x][(int) ((p1.getY() + 1) % SIZE)];
                    newChar2 = chars[x][(int) ((p2.getY() + 1) % SIZE)];
                }
            } else if (p1.getY() == p2.getY()) {
                int y = (int) p1.getY();
                if (Math.abs(p2.getX() - p1.getX()) == 1) {
                    newChar1 = chars[(int) ((p1.getX() + 2) % SIZE)][y];
                    newChar2 = chars[(int) ((p2.getX() + 2) % SIZE)][y];
                } else {
                    newChar1 = chars[(int) (p1.getX() + 1 % SIZE)][y];
                    newChar2 = chars[(int) (p2.getX() + 1 % SIZE)][y];
                }
            } else {
                newChar1 = chars[(int) p1.getX()][(int) p2.getY()];
                newChar2 = chars[(int) p2.getX()][(int) p1.getY()];
            }
            tableOfChange.add(new Pair<String, String>(String.valueOf(pair.getKey()), String.valueOf(newChar1)));
            tableOfChange.add(new Pair<String, String>(String.valueOf(pair.getValue()), String.valueOf(newChar2)));
            result.append(String.valueOf(newChar1) + String.valueOf(newChar2) + Constants.SPACE);
        }


        return result.toString().trim();
    }

    private List<Pair<Character, Character>> splitToPairs(String word) {
        List<Pair<Character, Character>> pairs = new ArrayList<>();
        for (int i = 0, n = word.length(); i < n; i++) {
            if (i + 1 == n || word.charAt(i) == word.charAt(i + 1)) {
                pairs.add(new Pair<>(word.charAt(i), REPLACEMENT));
            } else {
                pairs.add(new Pair<>(word.charAt(i), word.charAt(++i)));
            }
        }
        return pairs;
    }

    private Point getCoordinatesOfLetter(char letter) {
        if (letter == 'j') {
            return new Point(0, 1);
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (letter == chars[i][j])
                    return new Point(i, j);
            }
        }
        return null;
    }
}
