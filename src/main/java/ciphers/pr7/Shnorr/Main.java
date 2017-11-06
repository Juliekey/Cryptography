package ciphers.pr7.Shnorr;

public class Main {
    public static void main(String[] args) {
        ClientA a = new ClientA();
        ClientB b = new ClientB();
        a.generate();
        getResult(a, b, "pri");
    }
    public static void getResult(ClientA a, ClientB b, String word){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            a.setR(word.charAt(i));
            b.setE();
            a.setS(b.getE());
            sb.append(a.getR());
            boolean res = b.authentificate(a.getR(), a.getG(), a.getS(), a.getY());
            System.out.println(res);
        }
        System.out.println(sb);
    }
}
