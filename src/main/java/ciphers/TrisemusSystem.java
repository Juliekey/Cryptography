package ciphers;

public class TrisemusSystem extends Cipher {
    public TrisemusSystem() {
        key = "трисемус";
    }

    public final static int SIDE = 6;
    private static char[][] matrix =
            {{'т', 'р', 'и', 'с', 'е', 'м'},
                    {'у', 'а', 'б', 'в', 'г', 'д'},
                    {'ё', 'ж', 'з', 'й', 'к', 'л'},
                    {'н', 'о', 'п', 'ф', 'х', 'ц',},
                    {'ч', 'ш', 'щ', 'ъ', 'ы', 'ь',},
                    {'э', 'ю', 'я', ' ', '.', ','}};

    public String encrypt(String word) {
        StringBuffer encrypted = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            for (int j = 0; j < SIDE; j++) {
                boolean found = false;
                for (int k = 0; k < SIDE; k++) {
                    if (matrix[j][k] == word.charAt(i)) {


                        char newChar = i == SIDE - 1 ?
                                matrix[0][k] : matrix[j + 1][k];

                        encrypted.append(newChar);
                        tableOfChange.put(String.valueOf(word.charAt(i)), String.valueOf(newChar));
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

        }

        return encrypted.toString();
    }

}
