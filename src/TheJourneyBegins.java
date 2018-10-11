package org.matt.codefights.arcade.intro;


public class TheJourneyBegins {

    int add(int param1, int param2) {
        return param1 + param2;
    }

    int centuryFromYear(int year) {

        int r = year / 100;

        if (year % 100 != 0) {
            r++;
        }
        return r;
    }

    boolean checkPalindrome(String inputString) {

        int length = inputString.length();

        for (int i = 0; i < length; i++) {

            char a = inputString.charAt(i);
            char b = inputString.charAt(length - i - 1);

            if (a != b) {
                return false;
            }
        }
        return true;
    }
}
