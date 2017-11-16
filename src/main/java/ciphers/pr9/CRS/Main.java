package ciphers.pr9.CRS;

public class Main {
    public static void main(String[] args) {
        CRS crs = new CRS();
        String controlSum = crs.getControlSum(17);
        System.out.println("Quotient: " + crs.getQuotient());
        System.out.println("Result: " + crs.getInputDataWithControlSum());
        System.out.println("Control sum: " + controlSum);
    }
}
