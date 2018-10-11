package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/3/17.
 */
public class isIPV4Address {

    public static boolean isIPv4Address(String inputString) {
        String[] numbers = inputString.split("\\.");
        if(numbers.length != 4)
            return false;

        for(String number : numbers) {
            if(number == null || number.isEmpty())
                return false;
            try {
                int value = Integer.parseInt(number);
                if(value < 0 || value > 255)
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIPv4Address("1.22.34.55"));
        System.out.println(isIPv4Address("0.234.34.55"));
        System.out.println(isIPv4Address("0.0.0.0"));
        System.out.println(isIPv4Address("1000.22.34.55"));
        System.out.println(isIPv4Address("a.22.34.55"));
        System.out.println(isIPv4Address("-123.22.34.55"));
    }

}
