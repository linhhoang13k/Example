package arcade.bookMarket;

/**
 * Created by JavierSainz on 11/12/16.
 */
public class UnstablePair {
    boolean isUnstablePair(String filename1, String filename2) {
        if (filename1.equals(filename2)) {
            return false;
        }
        String filename1Upper = filename1.toUpperCase();
        String filename2Upper =  filename2.toUpperCase();
        String filename1Lower = filename1.toLowerCase();
        String filename2Lower =  filename2.toLowerCase();

        if (isSmaller(filename1, filename2)) {
            if (isSmaller(filename2Upper, filename1Upper) ||
                    filename2Upper.equals(filename1Upper) ||
                    isSmaller(filename2Lower, filename1Lower) ||
                    filename2Lower.equals(filename1Lower)) {
                return true;
            }
        } else if (isSmaller(filename1Upper, filename2Upper) ||
                filename1Upper.equals(filename2Upper) ||
                isSmaller(filename1Lower, filename2Lower) ||
                filename1Lower.equals(filename2Lower)) {
            return true;
        }

        return false;
    }

    boolean isSmaller(String name1, String name2) {
        int length = Math.min(name1.length(), name2.length());
        for (int index  = 0; index < length; index++) {
            char c1 =  name1.charAt(index);
            char c2 =  name2.charAt(index);
            if (c1 < c2) {
                return true;
            } else if (c2 < c1) {
                return false;
            }
        }
        return name1.length() < name2.length();
    }

    public static void main(String[] args) {
        System.out.println(new UnstablePair().isUnstablePair("aa", "AAB"));
    }
}
