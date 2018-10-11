package challenge;

import java.util.*;

/**
 * Created by JavierSainz on 12/17/16.
 */
public class FriendGroups {
    int friendGroups(int n, int[][] friends) {
        List<Set<Integer>> groups =  new ArrayList<>();
        for (int[] pair: friends) {
            boolean found =  false;
            for (Set<Integer> group: groups) {
                if (group.contains(pair[0]) || group.contains(pair[1])) {
                    group.add(pair[0]);
                    group.add(pair[1]);
                    Iterator<Set<Integer>> t = groups.iterator();
                    while (t.hasNext()) {
                        Set<Integer> group2  = t.next();
                        if (group2 != group && (group2.contains(pair[0]) || group2.contains(pair[0]))) {
                            group.addAll(group2);
                            t.remove();
                        }
                    }
                    found = true;
                }
            }

            if (!found) {
                groups.add(new HashSet<Integer>(){{add(pair[0]); add(pair[1]);}});
            }
        }
        int total = 0;
        for (Set<Integer> l :  groups)
            total += l.size();
        return groups.size() + (n - total);
    }

    public static void main(String[] args) {
        System.out.println(new FriendGroups().friendGroups(5, new int[][]{
                {2,3},
                {4,3},
                {2,4}
        }));
    }

}
