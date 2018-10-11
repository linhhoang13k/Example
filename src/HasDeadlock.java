package interviewpractice.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author benmakusha
 */
public class HasDeadlock {

    boolean hasDeadlock(int[][] connections) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < connections.length; i++) {
            visited.add(i);
            boolean nodeSearch = DFS(connections, i, visited);
            if (nodeSearch)
                return true;
            visited = new HashSet<>();
        }
        return false;
    }

    boolean DFS(int[][] connections, int startNode, Set<Integer> vSet) {
        for (int i = 0; i < connections[startNode].length; i++) {
            if (vSet.contains(connections[startNode][i])){
                return true;
            } else {
                vSet.add(connections[startNode][i]);
                boolean nodeSearch = DFS(connections, connections[startNode][i], vSet);
                if (nodeSearch) {
                    return true;
                }
                vSet.remove(connections[startNode][i]);
            }
        }
        return false;
    }

}
