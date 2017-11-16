package ciphers.pr9.evenbits;

public class EvenBits {
    public int getParitetBit(String msg) {
        int count = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 2 == 0) {
            return 0;
        }
        return 1;
    }
}
