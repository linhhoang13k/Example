import java.util.List;
import java.util.ArrayList;

public class SparseArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<String> inputs = new ArrayList<>();
        List<String> queries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String a = in.next();
            inputs.add(a);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            String a = in.next();
            queries.add(a);
        }

        for (String query : queries) {
            int instances = 0;
            for (String input : inputs) {
                if (query.equals(input))
                    instances++;
            }
            System.out.println(instances);
        }


    }
}
