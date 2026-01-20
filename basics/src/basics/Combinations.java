package basics;

import java.util.Scanner;
import java.math.BigInteger;

public class Combinations {

    public static BigInteger facto(long v) {
        BigInteger fact = BigInteger.ONE;

        for (long i = v; i > 0; i--) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long r = sc.nextLong();

        // Validation
        if (r < 0 || n < 0 || r > n) {
            System.out.println("Invalid input");
            return;
        }

        BigInteger factN = facto(n);
        System.out.println(factN);

        BigInteger factR = facto(r);
        System.out.println(factR);

        BigInteger factNR = facto(n - r);

        BigInteger comb = factN.divide(factR.multiply(factNR));
        System.out.println(comb);
    }
}
