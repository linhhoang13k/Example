package codefights;

import java.math.BigInteger;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class Sum34 {

    public static int sum34(int n) {
        return ("" + new BigInteger("2").pow(n)).chars().map(Character::getNumericValue).sum();
    }

    public static void main(String[] args) {

        System.err.println("1 : " + sum34(1));
        System.err.println("2 : " + sum34(2));
        System.err.println("3 : " + sum34(3));
        System.err.println("4 : " + sum34(4));
        System.err.println("5 : " + sum34(5));
        System.err.println("100 : " + sum34(100));
        System.err.println("1234 : " + sum34(1234));
    }
}
