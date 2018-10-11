package arcade.bookMarket;

/**
 * Created by JavierSainz on 11/6/16.
 */
public class CaseInsensitivePalindrome {
    boolean isCaseInsensitivePalindrome(String inputString) {
        inputString = inputString.toLowerCase();
        int middle = inputString.length() / 2;
        for (int index = 0; index < middle; index++) {
            if (inputString.charAt(index) != inputString.charAt(inputString.length() - 1 - index)) {
                return false;
            }
        }
        return true;
    }

    boolean isCaseInsensitivePalindrome2(String inputString) {
        return inputString.equalsIgnoreCase(new StringBuilder(inputString).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new CaseInsensitivePalindrome().isCaseInsensitivePalindrome2("opOP"));
    }
}
