package arcade.nestedLoops;

/**
 * Created by JavierSainz on 11/3/16.
 */
public class WeakNumbers {
    int[] weakNumbers(int n) {
        int [] divisorsArray = new int[n];
        int maxWeakness = 0;
        int weekCount = 0;
        for (int i = 1; i <= n; i++) {
            int divisors = divisors(i);
            int numberWeakness = 0;
            for (int j = 0; j < i - 1; j++) {
                if (divisors < divisorsArray[j]) {
                    numberWeakness++;
                }
            }
            if (numberWeakness > maxWeakness) {
                maxWeakness = numberWeakness;
                weekCount = 1;
            } else if (numberWeakness == maxWeakness) {
                weekCount++;
            }
            divisorsArray[i - 1] = divisors;
        }
        return new int[] {maxWeakness, weekCount};
    }

    int divisors(int number) {
        if (number == 1) {
            return 1;
        }

        int count = 2;
        int middle = number / 2;
        for (int i = 2; i <= middle; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
}
