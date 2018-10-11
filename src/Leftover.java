package in.mkp.challenges;

/**
 https://codefights.com/challenge/QfFQ8aFHHry5Fsbu9
 */
public class LeftOver {

    public static void main(String[] args) {
        LeftOver leftOver = new LeftOver();
        System.out.println("leftOver.leftover(\"antidisestablishmentarianism\") = "
                + leftOver.leftover("antidisestablishmentarianism"));

        System.out.println("leftOver.leftover(\"supercalifragilisticexpialidocious\") = "
                + leftOver.leftover("supercalifragilisticexpialidocious"));

        System.out.println("leftOver.leftover(\"appetite\") = "
                + leftOver.leftover("appetite"));

        System.out.println("leftOver.leftover(\"2017\") = "
                + leftOver.leftover("2017"));

        System.out.println("leftOver.leftover(\"bc\") = "
                + leftOver.leftover("bc"));
    }

    int leftover(String s) {
        int sum=0;
        for (int i=0; i < s.length(); ++i)
            sum+=s.charAt(i);

        return (sum%s.length());
    }
}
