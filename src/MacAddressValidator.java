package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/14/17.
 * A media access control address (MAC address) is a unique identifier assigned to network interfaces for communications on the physical network segment.

 The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).

 Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.

 Example

 For inputString = "00-1B-63-84-45-E6", the output should be
 isMAC48Address(inputString) = true;
 For inputString = "Z1-1B-63-84-45-E6", the output should be
 isMAC48Address(inputString) = false;
 For inputString = "not a MAC-48 address", the output should be
 isMAC48Address(inputString) = false.
 */
public class MacAddressValidator {

    public static boolean isMAC48Address(String inputString) {
        return inputString.matches("^([A-F\\d]{2}-){5}[A-F\\d]{2}$");
    }


    public static void main(String[] args) {
        System.out.println(isMAC48Address("00-1B-63-84-45-E6"));
        System.out.println(isMAC48Address("Z1-1B-63-84-45-E6"));
        System.out.println(isMAC48Address("not a MAC-48 address"));
        System.out.println(isMAC48Address("FF-FF-FF-FF-FF-FF"));
        System.out.println(isMAC48Address("00-00-00-00-00-00"));
        System.out.println(isMAC48Address("G0-00-00-00-00-00"));
        System.out.println(isMAC48Address("02-03-04-05-06-07-"));
        System.out.println(isMAC48Address("12-34-56-78-9A-BC"));
    }
}
