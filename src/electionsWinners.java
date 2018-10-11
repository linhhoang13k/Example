package in.mkp.basic.level10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Created by mkumar on 3/12/17.
 */
public class ElectionsWinners {

    public static void main(final String[] args) {
        ElectionsWinners electionsWinners = new ElectionsWinners();
        System.out.println(electionsWinners.electionsWinners(new int[]{2, 3, 5, 2}, 3));

    }

    int electionsWinners(int[] votes, int k) {
        final IntSummaryStatistics stats = Arrays.stream(votes).summaryStatistics();
        final int max = stats.getMax();

        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < votes.length; ++i) {
            if ((votes[i] == max) || (votes[i] + k > max)) {
                count++;
            }
            if (votes[i] == max) {
                maxCount++;
            }
        }

        return maxCount > 1 && k == 0 ? 0 : count;
    }

}
