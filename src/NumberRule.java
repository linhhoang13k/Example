package challenge;

/**
 * Created by JavierSainz on 1/24/17.
 */
public class NumberRule {
    boolean NumberRuleClean(int inputNumber) {
        int last = 9;
        while (inputNumber > 0) {
            int digit = inputNumber % 10;
            if (digit > last) {
                return false;
            }
            last = digit;
            inputNumber /= 10;
        }
        return true;
    }

    int NumberRule(int i) {
        for (int l = 9; i > 0; l = i % 10, i /= 10)
            if (i % 10 > l)
                return 0;
        return 1;
    }

    //solution by alexander_k456
    int NumberRuleBest(int i) {
        while (i % 10 < (i /= 10) % 10 ^ i > 0) ;
        return 1 >> i;
    }


    public static void main(String[] args) {
        int[] validNumbers = new int[]{1,
                124,
                248,
                123,
                99999999,
                0,
                222888889,
                14445668};
        int[] invalidNumbers = new int[]{753,
                253,
                483,
                1000000000,
                825743724,
                11825148,
                592855757};
        NumberRule instance = new NumberRule();
        System.out.println("Valid Numbers!");
        for (int number : validNumbers) {
            System.out.println(instance.NumberRuleBest(number));
        }
        System.out.println("Invalid Numbers!");
        for (int number : invalidNumbers) {
            System.out.println(instance.NumberRuleBest(number));
        }

    }

}
