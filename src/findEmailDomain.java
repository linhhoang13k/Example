package arcade.bookMarket;

/**
 * Created by JavierSainz on 11/6/16.
 */
public class FindEmailDomain {
    String findEmailDomain(String address) {
        //return address.substring(address.lastIndexOf('@') + 1);
        for (int index = address.length() - 1; index > 0; index--) {
            if (address.charAt(index) == '@') {
                return address.substring(index + 1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new FindEmailDomain().findEmailDomain("\" \"@xample.org"));
    }

}
