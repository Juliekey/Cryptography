package ciphers.pr9.evenbits;

public class Main {
    static EvenBits evenBits = new EvenBits();

    public static void main(String[] args) {
        String msg = "1100 1111 1100 0101 1100 0100 1100 0000 1101 1000";
        System.out.println("Message is " + msg);
        System.out.println("Paritet bit is " + evenBits.getParitetBit(msg));
    }
}
