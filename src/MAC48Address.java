package arcade.bookMarket;

/**
 * Created by JavierSainz on 11/6/16.
 */
public class MAC48Address {
    boolean isMAC48Address(String inputString) {
        if (inputString.length() != 17) {
            return false;
        }
        int state = 0;
        for (int index = 0; index < inputString.length(); index++) {
            char c = inputString.charAt(index);
            if (state == 0 || state == 1) {
                if ((c < '0' || c > '9') && (c < 'A' || c > 'F')) {
                    return false;
                }
                state++;
            } else {
                if (c != '-') {
                    return false;
                }
                state = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MAC48Address().isMAC48Address("G0-00-00-00-00-00"));
    }

}
