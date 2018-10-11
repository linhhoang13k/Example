package in.mkp.challenges;

/**
 * Created by mkumar on 4/23/17.
 */
public class CharWeight {

    public static void main(String[] args) {
        CharWeight charWeight = new CharWeight();
        System.out.println("charWeight.charWeight(\"1abc10DefA7892164aSd\") = " + charWeight.charWeight("1abc10DefA7892164aSd"));
    }

    String charWeight(String s) {
        int[] a = new int[125];
        s.toLowerCase().chars().forEach(c -> a[c]++);
        String ret = "";
        for (int k = s.length(); k > 0; --k)
            for (int i = 0; i < 125; ++i)
                if (a[i] == k)
                    ret += (char) i + "{" + k + "}";
        return ret;
    }

}
