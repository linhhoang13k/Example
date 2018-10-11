package HackerRank;

import java.util.*;

/**
 * Basic BFS, edge lengths of 6.
 *
 * Problem description:
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 */
public class BFS {

    class Node {
        int nodeName;
        Node parent;
        int distance;

        Node(int nodeName, Node parent, int distance) {
            this.nodeName = nodeName;
            this.parent = parent;
            this.distance = distance;
        }
    }

    int[] bfs(ArrayList<ArrayList<Integer>> adjacencies, int startNode) {

        int[] results = new int[adjacencies.size()];        // will store shortest distance to each node
        HashSet<Integer> visited = new HashSet<>();         // set of visited nodes
        LinkedList<Node> frontier = new LinkedList<>();     // frontier

        frontier.add(new Node(startNode, null, 0));

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            if (!visited.contains(current.nodeName)) {
                // Add neighbours to the frontier
                for (int neighbour : adjacencies.get(current.nodeName)) {
                    if (!visited.contains(neighbour))
                        frontier.add(new Node(neighbour, current, current.distance + 6));
                }
                // add distance to this node to the results
                visited.add(current.nodeName);
                results[current.nodeName] = current.distance;
            }
        }

        // build results
        for (int i = 0; i < adjacencies.size(); i++) {
            // if node wasn't visited, it is unreachable
            if (!visited.contains(i))
                results[i] = -1;
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numProblems = in.nextInt();                   // number of problems to be read
        //System.out.println("Num problems = " + numProblems);

        for (int p = 0; p < numProblems; p++) {
            // set up arrayList of arrayLists to store adjacent nodes
            int numNodes = in.nextInt();
            //System.out.println("Number of nodes = " + numNodes);
            ArrayList<ArrayList<Integer>> adjacencies = new ArrayList<>();
            for (int node = 0; node < numNodes; node++) {
                adjacencies.add(new ArrayList<>());               // create empty arraylist for each node
            }

            int numEdges = in.nextInt();
            //System.out.println("Num edges = " + numEdges);
            for (int edge = 0; edge < numEdges; edge++) {                   // populate matrix
                int u = in.nextInt() - 1;
                //System.out.println("First node: " + u);
                int v = in.nextInt() - 1;
                //System.out.println("Second node: " + v);
                adjacencies.get(u).add(v);              // add adjacents in both directions
                adjacencies.get(v).add(u);
            }
            for (int i = 0; i < adjacencies.size(); i++) {
                //System.out.println(adjacencies.get(i).toString());
            }

            int startNode = in.nextInt() - 1;
            //System.out.println("Start node: " + startNode);

            BFS sol = new BFS();

            int[] results = sol.bfs(adjacencies, startNode);

            for (int result : results) {
                if (result != 0)
                    System.out.print(result + " ");
            }
        }
    }
}
