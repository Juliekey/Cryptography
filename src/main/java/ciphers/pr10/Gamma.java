package ciphers.pr10;


public class Gamma{

    public static void main(String[] args) {
        String encrypted = encrypt("pri", "cip", "ped", "lyo");
        String res = encrypt(encrypted, "cip", "ped", "lyo");
        System.out.println(encrypted+" "+toBin(encrypted));
        System.out.println(res+" "+toBin(res));
    }
    public static String encrypt(String word, String... gamma) {
        String[] binary1, binary2, binary3, binary4;
        int[] result;
        StringBuffer sb = new StringBuffer();
        binary1 = new String[word.length()];
        binary2 = new String[word.length()];
        binary3 = new String[word.length()];
        binary4 = new String[word.length()];
        result = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            binary1[i] = Integer.toBinaryString(word.charAt(i));
            binary2[i] = Integer.toBinaryString(gamma[0].charAt(i));
            binary3[i] = Integer.toBinaryString(gamma[1].charAt(i));
            binary4[i] = Integer.toBinaryString(gamma[2].charAt(i));
            result[i] = Integer.parseInt(binary1[i], 2)^Integer.parseInt(binary2[i], 2)^
                    Integer.parseInt(binary3[i], 2)^Integer.parseInt(binary4[i], 2);
            sb.append((char)('a'+(result[i]-1)));
        }
        return sb.toString();
    }
    public static String toBin(String word){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            sb.append(Integer.toBinaryString(word.charAt(i)));
        }
        return sb.toString();
    }

}
