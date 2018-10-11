package Arcade_Intro;

public class _26_evenDigitsOnly {
    boolean evenDigitsOnly(int n) {
        while(n > 0){
            if(n % 2 != 0) return false;
            n = n / 10;
        }
        return true;
    }

    boolean evenDigitsOnlyBetter(int n) {
        return Integer.toString(n).matches("(0|2|4|6|8)*");
    }
}
