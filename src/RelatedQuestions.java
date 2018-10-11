package com.codefights.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RelatedQuestions {

	public int relatedQuestions(int n, int[] t, int[][] edges) {
		if (edges.length == 0)
			return 0;
		Map<Integer, Node> nodeMap = new HashMap();
		for (int[] edge : edges) {
			if (!nodeMap.containsKey(edge[0]))
				nodeMap.put(edge[0], new Node(edge[0], t[edge[0]]));
			if (!nodeMap.containsKey(edge[1]))
				nodeMap.put(edge[1], new Node(edge[1], t[edge[1]]));
			Node node1 = nodeMap.get(edge[0]);
			Node node2 = nodeMap.get(edge[1]);
			node1.neighbors.add(node2);
			node2.neighbors.add(node1);
		}
		double minTime = Double.MAX_VALUE;
		int index = 0, minNodeIndex = -1;
		for (int nodeId : nodeMap.keySet()) {
			Node currentNode = nodeMap.get(nodeId);
			Set<Integer> visited = new HashSet();
			visited.add(currentNode.id);
			double time = calculateReadingTime(currentNode, visited);
			if (time < minTime || time == minTime && index < minNodeIndex) {
				minNodeIndex = index;
				minTime = time;
			}
			index++;
		}
		return minNodeIndex;
	}

	private double calculateReadingTime(Node currentNode, Set<Integer> visited) {
		int neighborSize = 0;
		double totalTime = 0;
		for (Node neighbor : currentNode.neighbors) {
			if (!visited.contains(neighbor.id)) {
				visited.add(currentNode.id);
				totalTime = totalTime + calculateReadingTime(neighbor, visited);
				neighborSize = neighborSize + 1;
			}
		}
		return neighborSize == 0 ? currentNode.time : currentNode.time + totalTime / neighborSize;
	}

}

class Node {
	int id;
	double time;
	List<Node> neighbors;

	Node(int id, double time) {
		this.id = id;
		this.time = time;
		neighbors = new ArrayList();
	}
}
