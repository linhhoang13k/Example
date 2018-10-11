package com.il.training.hackerrank.ctci;

import java.util.*;

/**
 * Created by cesaregb on 12/2/16.
 */
public class BFSShortestReach {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int queries = scanner.nextInt();
    HashMap<Integer, NodeG> nodesList = new HashMap<>();

    for (int t = 0; t < queries; t++) {

      nodesList = new HashMap<>();

      // Create a graph of size n where each edge weight is 6:
      int n = scanner.nextInt();
      for (int a = 0; a < n; a++) {
        nodesList.put(a, new NodeG(a));
      }
      int m = scanner.nextInt();

      // read and set edges
      for (int i = 0; i < m; i++) {
        int u = scanner.nextInt() - 1;
        int v = scanner.nextInt() - 1;

        // add each edge to the graph
        nodesList.putIfAbsent(u, new NodeG(u));
        nodesList.putIfAbsent(v, new NodeG(v));

        nodesList.get(u).addNode(nodesList.get(v)); // manage bidirectional relationship
      }

      Graph g = new Graph();
      g.setNodes(nodesList);
      // Find shortest reach from node s
      int startId = scanner.nextInt() - 1;
      int[] distances = g.shortestReach(startId);

      for (int i = 0; i < distances.length; i++) {
        if (i != startId) {
          System.out.print(distances[i]);
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    scanner.close();
  }

}

@SuppressWarnings("ALL")
class Graph {

  HashMap<Integer, NodeG> nodes;
  int edgeWeight = 6;


  public HashMap<Integer, NodeG> getNodes() {
    return nodes;
  }

  public void setNodes(HashMap<Integer, NodeG> nodes) {
    this.nodes = nodes;
  }

  public int[] shortestReach(int node) {
    NodeG n = nodes.get(node);

    if (n == null) {
      return null;
    }
    HashMap<Integer, Integer> visited = new HashMap<>();
    visited.put(n.val, 0); // maybe i should add me...

    Queue<NodeG> q = new LinkedList<>();
    n.nodes.forEach(nChild -> {
      q.add(nChild);
      visited.put(nChild.val, 1);
    });

    while (!q.isEmpty()) {
      NodeG nHelper = q.poll();
      nHelper.nodes.forEach(nChild -> {
        if (visited.get(nChild.val) == null) {
          q.add(nChild);
          visited.put(nChild.val, (visited.get(nHelper.val) + 1));
        }
      });
    }

    int[] result = new int[nodes.size()];
    this.nodes.forEach((k, v) -> {
      if (visited.get(k) != null) {
        result[k] = visited.get(k) * edgeWeight;
      } else {
        result[k] = -1;
      }
    });

    return result;
  }

//	static class PQsort implements Comparator<NodeHolder> {
//		public int compare(NodeHolder one, NodeHolder two) {
//			return one.node.val - two.node.val;
//		}
//	}

}

class NodeHolder {
  NodeG node;
  int weight;
}

class NodeG {

  int val;
  Set<NodeG> nodes = new HashSet<>();

  public NodeG(int v) {
    this.val = v;
  }

  public void addNode(NodeG n) {
    if (!nodes.contains(n)) { //bidirectional
      nodes.add(n);
      n.addNode(this);
    }
  }
}

