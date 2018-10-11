package com.github.chen0040.codefights.depthfirst;


/**
 * Created by xschen on 4/8/2017.
 *
 * You have a connected directed graph that has positive weights in the adjacency matrix g. The graph is represented as a square matrix, where g[i][j] is the weight of the edge (i, j), or -1 if there is no such edge.

 Given g and the index of a start vertex s, find the minimal distances between the start vertex s and each of the vertices of the graph.

 Example

 For

 g = [[-1, 3, 2],
 [2, -1, 0],
 [-1, 0, -1]]
 and s = 0, the output should be
 graphDistances(g, s) = [0, 2, 2].

 Example

 The distance from the start vertex 0 to itself is 0.
 The distance from the start vertex 0 to vertex 1 is 2 + 0 = 2.
 The distance from the start vertex 0 to vertex 2 is 2.
 Input/Output

 [time limit] 3000ms (java)
 [input] array.array.integer g

 The graph is represented as a square matrix, as described above.

 Guaranteed constraints:
 1 ≤ g.length ≤ 100,
 g.length = g[i].length,
 -1 ≤ g[i][j] ≤ 30.

 [input] integer s

 The start vertex (0-based).

 Guaranteed constraints:
 0 ≤ s < g.length.

 [output] array.integer

 An array, the ith element of which is equal to the distance between the start vertex s and the ith vertex of the graph g.
 */
public class GraphDistance {
   int[] graphDistances(int[][] g, int s) {
      int V = g.length;
      int[] costs = new int[V];
      int[] edgeTo = new int[V];
      for(int v=0; v < V; ++v) {
         costs[v] = Integer.MAX_VALUE / 2;
         edgeTo[v] = -1;
      }
      costs[s] = 0;
      for(int i=0; i < V; ++i) {
         for(int v = 0; v < V; ++v){
            for(int w = 0; w < V; ++w){
               if(w == v || g[v][w] == -1) {
                  continue;
               }
               relax(g, s, costs, edgeTo, v, w);
            }
         }
      }

      return costs;
   }

   void relax(int[][] g, int s, int[] costs, int[] edgeTo, int v, int w) {
      if(costs[w] > costs[v] + g[v][w]){
         costs[w] = costs[v] + g[v][w];
         edgeTo[w] = v;
      }
   }

}
