package ciphers.pr9.ECC;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a[] = {1, 0, 1, 1, 1, 0};
        System.out.println("Input data:");
        System.out.println(Arrays.toString(a).replace(",", "").replace("[", "")
                .replace("]", "").replace(" ", ""));
        ECC c = new ECC();
        int b[] = c.generateCode(a);

        System.out.println("Generated code is:");
        for(int i=0 ; i < b.length ; i++) {
            System.out.print(b[b.length-i-1]);
        }
        System.out.println();

        int error = 5;
        if(error != 0) {
            b[error-1] = (b[error-1]+1)%2;
        }
        c.receive(b, b.length - a.length);
    }
}
