package ciphers;

public class Lozung implements Cipher {
    public static char[] chars = {'c', 'i', 'p', 'h', 'e', 'r', 'a', 'b', 'd', 'f', 'g', 'j', 'k',
            'l', 'm', 'n', 'o', 'q', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String encrypt(String word) {
        word = word.toLowerCase();
        System.out.println("Initial word: " + word);
        System.out.println("Slogan: " + "Cipher");
        StringBuffer encoded = new StringBuffer();
        for (int i = 0, n = word.length(); i < n; i++) {
            encoded.append(chars[word.charAt(i) - Constants.LC_A_ASCII_INDEX]);
            System.out.println(word.charAt(i) + "->" + chars[word.charAt(i) - Constants.LC_A_ASCII_INDEX]);
            System.out.println("On step " + i + " word is: " + encoded);
            System.out.println();
        }
        return encoded.toString();
    }
}
