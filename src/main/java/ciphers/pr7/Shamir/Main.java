package ciphers.pr7.Shamir;

public class Main {
    public static void main(String[] args) {
        Shamir s = new Shamir();
        s.generate();
        ClientA a = new ClientA();
        ClientB b = new ClientB();
        getResult(a, b, s, "pri");

    }
    public static void getResult(ClientA a, ClientB b, Shamir s, String word){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            a.setZ(word.charAt(i), s.getP());
            sb.append(a.getZ());
            a.getRorY(b.getRandomBit(), s.getS(), s.getP());
            boolean res = b.authentificate(a.getZ(), a.getY(), s.getV(), s.getP(), a.getR());
        }
        System.out.println("Encrypted:" + sb);
    }
}
