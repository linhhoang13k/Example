package interviewpractice.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author benmakusha
 */
public class SinglePointOfFailure {

    int singlePointOfFailure(int[][] connections) {
        // check each connection (a,b) for a way to get back to a from b
        // add one to edge (a,b) and (b,a) after it is searched
        int count = 0;
        for (int i = 0; i < connections.length; i++){
            for (int j = 0; j < connections[0].length; j++){
                if (connections[i][j] == 1){
                    // use set to ensure each vertex can only be search once from another vertex
                    Set<Integer> h = new HashSet<>();
                    h.add(i);
                    count += findFailure(connections, i, j, i, h);
                    connections[i][j] = 2;
                    connections[j][i] = 2;
                }
            }
        }
        return count;
    }

    // return 0 if there is no failure
    // x is first i
    int findFailure(int[][] c, int i, int j, int x, Set<Integer> h){
        // return false if there is an edge, and therefore no failure
        if (i != x && c[i][j] > 0) return 0;
        // check connected vertices for edge
        for (int k = 0; k < c.length; k++){
            if (c[i][k] > 0 && k != j && h.add(k) && findFailure(c, k, j, x, h) == 0)
                return 0;
        }
        return 1;
    }
}
