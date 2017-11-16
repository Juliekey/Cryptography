package ciphers.pr9.luna;

public class Main {
    public static void main(String[] args) {
        Luna luna = new Luna();
        byte[] number = {2, 7, 5, 8, 6, 2, 0, 8, 4, 2, 0, 0, 0, 2, 1, 3};
        int result = luna.getControlNumber(number);
        System.out.println(result);
    }
}
