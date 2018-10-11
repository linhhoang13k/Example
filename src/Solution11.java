package com.il.training.hackerrank.sad_examples.oct;

import java.util.*;

/**
 * Created by cesaregb on 10/15/16.
 */
public class Solution11 {

  public static void main(String[] args) {
    HashMap<Integer, NodeG> nodesList = new HashMap<>();


    NodeG n0 = new NodeG(0);
    NodeG n1 = new NodeG(1);
    NodeG n2 = new NodeG(2);
    NodeG n3 = new NodeG(3);
    NodeG n4 = new NodeG(4);
    NodeG n5 = new NodeG(5);
    NodeG n6 = new NodeG(6);

    n0.addNode(n1);
    n0.addNode(n2);

    nodesList.put(0, n0);
    nodesList.put(1, n1);
    nodesList.put(2, n2);
    nodesList.put(3, n3);
//		nodesList.put(4, n4);
//		nodesList.put(5, n5);
//		nodesList.put(6, n6);


    Graph g = new Graph();
    g.setNodes(nodesList);

    int[] distances = g.shortestReach(0);
    System.out.println("l: " + distances.length);

    for (int i = 0; i < distances.length; i++) {
      System.out.print(distances[i]);
      System.out.print(" ");
    }
    System.out.println();

  }

}

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

//		PriorityQueue<NodeHolder> pq = new PriorityQueue<>(new PQsort());
//		visited.forEach((k, v) -> {
//			NodeHolder nh = new NodeHolder();
//			nh.node = nodes.get(k);
//			nh.weight = v;
//			pq.add(nh);
//
//		});
//
//
//		while (pq.size() != 0){
//			NodeHolder nh = pq.poll();
//			result[(nh.node.val)] = nh.weight * this.edgeWeight;
//		}

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

