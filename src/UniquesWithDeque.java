//note: this timed out for inputs > ~100000+ values
import java.util.*;
import java.util.List;

public class UniquesWithDeque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> numUniques = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            deque.add(num);
        }

        if(m == n)
            System.out.println(deque.stream().distinct().count());
        else{
            for( ; m < n; m++){
                numUniques.add((int) deque.stream().distinct().count());
                deque.removeFirst();
                deque.add(in.nextInt());
            }

            System.out.println(Collections.max(numUniques));
        }
    }
}
