package in.mkp.basic.level10;

/**
 * Created by mkumar on 3/11/17.
 */
public class BuildPalindrome {

    public static void main(String[] args) {
        BuildPalindrome buildPalindrome = new BuildPalindrome();
        System.out.println(buildPalindrome.buildPalindrome("abcdc"));
    }

    String buildPalindrome(String st) {
        String reversed = new StringBuffer(st).reverse().toString();
        System.out.println("Reversed="+reversed);

        int i = reversed.length()-1;
        String suffix = "";
        while (!isPalindrome(st+suffix)) {
            suffix = reversed.charAt(i) + suffix;
            i--;
        }

        System.out.println("suffix="+suffix);

        return st + suffix;
    }

    boolean isPalindrome(String s) {
        return  (new StringBuilder(s).reverse().toString()).equals(s);
    }
}
