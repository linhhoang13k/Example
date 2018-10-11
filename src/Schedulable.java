package in.mkp.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkumar on 3/19/17.
 */
public class Schedulable {

    public static void main(String[] args) {
        Schedulable schedulable = new Schedulable();
        System.out.println(schedulable.schedulable(new int[][] {{1,2}, {3,4}}));

    }

    boolean schedulable(int[][] tasks) {

        final List<ComputationalTask> list = new ArrayList<>();
        final int n = tasks.length;
        for (int i=0; i < n; ++i) {
            final ComputationalTask computationalTask = new ComputationalTask(tasks[i][0], tasks[i][1]);
            list.add(computationalTask);
        }

        final double lhs = list.stream().mapToDouble(i -> i.ratio()).summaryStatistics().getSum();

        final double rhs = (double) n * (Math.pow(2, (1.0/n)) -1.0);

        return lhs <= rhs;

    }

    class ComputationalTask {
        int c;
        int t;

        ComputationalTask(final int c, final int t) {
            this.c = c;
            this.t = t;
        }

        double ratio() {
            if (this.t != 0) {
                return ((double)this.c/this.t);
            }
            return 0.0;
        }
    }
}
